public class Atm {

    private BankUser currentUser;
    private int moneySupply;
    private static int sessionNumber = 0;
    private ConsoleAtmUserInterface ui = new ConsoleAtmUserInterface();

    public Atm(int moneySupply){
        this.moneySupply = moneySupply;
        //sessionNumber ++;
    }

    private void doCheckBalance(){
        ui.displayMessage("For which account?");

        Account[] accountArray = currentUser.getAccounts();

            for (int i = 0; i < accountArray.length; i++) {
                ui.displayMessage((i+1) + ". " + accountArray[i].toString());
            }

        int accountChoice = ui.readNumber();
        switch (accountChoice) {
            case 1: ui.displayMessage("Balance is $" + accountArray[0].getBalance());// return user.Account1
                ui.displayMessage("");
                break;
            case 2: ui.displayMessage("Balance is $" + accountArray[1].getBalance()); // return user.Account2
                ui.displayMessage("");
                break;
            case 3: ui.displayMessage("Balance is $" + accountArray[2].getBalance()); // return user.Account3
                ui.displayMessage("");
                break;
            default: break;
        }
    }

    private void doDeposit(){
        ui.displayMessage("To which account?");

        Account[] accountArray = currentUser.getAccounts();

        for (int i = 0; i < accountArray.length; i++) {
            ui.displayMessage((i+1) + ". " + accountArray[i].toString());
        }

        int accountChoice = ui.readNumber();
        int deposit = ui.takeDepositEnvelope();

        switch (accountChoice) {
            case 1: accountArray[0].credit(deposit);
                // return user.Account1
                break;
            case 2: accountArray[1].credit(deposit); // return user.Account2\
                break;
            case 3: accountArray[2].credit(deposit); // return user.Account3
                break;
            default: break;
        }
    }

    private void doWithdrawal(){
        ui.displayMessage("From which account?");
        Account[] accountArray = currentUser.getAccounts();
        for (int i = 0; i < accountArray.length; i++){
            ui.displayMessage((i+1) + ". " + accountArray[i].toString());
        }
        int accountChoice = ui.readNumber();
        int amount = ui.readWithdrawalAmount();
        String insufficientFundsWarning = "No money transferred. Insufficient funds"; // Informs user that withdraw did not happen

        switch (accountChoice) {
            case 1: //accountArray[0].debit(amount);// return user.Account1
                if (!accountArray[0].debit(amount)) {
                    ui.displayError(insufficientFundsWarning);
                    ui.displayMessage("");
                    break;
                }
                ui.deliverMoney(amount);
                ui.displayMessage("");
                break;
            case 2: accountArray[1].debit(amount); // return user.Account2
                if (!accountArray[0].debit(amount)) {
                    ui.displayError(insufficientFundsWarning);
                    ui.displayMessage("");
                    break;
                }
                ui.deliverMoney(amount);
                ui.displayMessage("");
                break;
            case 3: //accountArray[2].debit(amount); // return user.Account3
                if (!accountArray[0].debit(amount)) {
                    ui.displayError(insufficientFundsWarning);
                    ui.displayMessage("");
                    break;
                }
                ui.deliverMoney(amount);
                ui.displayMessage("");
                break;
            default: break;
        }
    }



    public TransactionType performTransaction(){
        TransactionType transaction = ui.chooseTransactionType();
    if (transaction == null){
        currentUser = null;
        return null;
    }

    switch (transaction) {
        case DEPOSIT: this.doDeposit();
        break;
        case WITHDRAWAL: this.doWithdrawal();
        break;
        case CHECK_BALANCE: this.doCheckBalance();
        break;
        default: return null;
    }
        return transaction;
    }



    public void endSession(){
        ui.displayMessage("Goodbye!");
        currentUser = null;
    }



    boolean startSession() {
        sessionNumber ++;
        ui.displayMessage("");

        while (currentUser == null) { // asks for user info until a valid user is returned
            String givenID = ui.readCard();
            if (givenID == null){ // if true, ends program
                ui.displayMessage("Goodbye!");
                System.exit(0);
            }
            String givenPIN = ui.readPin();
            currentUser = BankUser.getUser(givenID, givenPIN); //Assigns currentUser to inputed user info
        }

        ui.displayMessage("");
        ui.displayMessage("Welcome, " + currentUser.name + "[$" + this.moneySupply + " in ATM].");
        ui.displayMessage("ATM Session #" + sessionNumber);
        return true;
    }
}
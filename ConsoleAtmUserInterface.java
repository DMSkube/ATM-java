import java.util.Scanner;

/**
 * @author skube
 * @version 1.0
 *
 */
public class ConsoleAtmUserInterface {
    private Scanner inDevice = new Scanner(System.in);
    private static String QUIT_STRING;



    public ConsoleAtmUserInterface(){
        Scanner inDevice = new Scanner(System.in);

    }



    public TransactionType chooseTransactionType(){
        this.displayMessage("Choose a transaction.");
        this.displayMessage("1. Check Balance");
        this.displayMessage("2. Withdraw");
        this.displayMessage("3. Deposit");
        this.displayMessage("4. Return Card");

       //int transaction = 0;
       //boolean condition = true;
       //while (condition){
           int transaction = this.readNumber();
           //if (transaction > 0 && transaction < 5){


           //}

        switch (transaction) {
            case 1: return TransactionType.valueOf("CHECK_BALANCE");
                //break;
            case 2: return TransactionType.valueOf("WITHDRAWAL"); // this.doWithdrawal();
            case 3: return TransactionType.valueOf("DEPOSIT"); //this.doDeposit();
            case 4: this.returnCard();

            default: break;
        }
        return null;
    }



    public void deliverMoney(int amount){
        this.displayMessage("Here is " + amount + " dollars.");
    }



    public void displayError(String errorMessage){

        System.out.println("Error! " + errorMessage + "!");
    }



    public void displayMessage(String message){

        System.out.println(message);
    }



    public int getAmount(){
        System.out.println("How much money?  ");
        return readNumber();
    }



    public Account readAccount(Account[] accounts){
        Account[] accountsGiven = accounts;
        for (int i = 0; i < accountsGiven.length; i++){
            this.displayMessage((i+1) + ". " + accountsGiven[i]);
        }

        this.displayMessage("Select the number of the account");
        int choice = this.readNumber();
        return accountsGiven[choice];

    }



    public String readCard(){
        this.displayMessage("Please enter your card ID or 'Q' to quit: ");
        String id = this.readString();
        if (id.equals("Q")) {
            return null;
        }
        return id;
        //return this.readString();
    }



    public int readNumber() {
        int num = 0;

        try{ num = inDevice.nextInt();
            //return inDevice.nextInt();
        }
        catch(Exception error){
            this.displayError(error.toString());
            this.displayMessage("Please enter a number.");
        }
    return num;
    }



    public String readPin(){
        System.out.println("Please enter your PIN: ");
        return readString();
    }



    private String readString(){
        return inDevice.next();
    }



    public int readWithdrawalAmount(){
        int withdrawalAmount = 0;

        while (withdrawalAmount < 1) {
        System.out.println("How much would you like to withdraw? Must be > $0.  ");
        withdrawalAmount = inDevice.nextInt();
        }
        return withdrawalAmount;
    }



    void returnCard(){
        this.displayMessage("Here's your card back!");
    }



    public int takeDepositEnvelope(){
        this.displayMessage("How much money is in this deposit envelope?");
        int envelopeAmount = this.readNumber();
        return envelopeAmount;
    }

}


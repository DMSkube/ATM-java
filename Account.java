public class Account{

    private String accountID;
    public int balance;
    private String name;
    private String type;

    private static int idCount;


    public Account(String type, String name, String accountID, int balance) {
        this.type = type;
        this.name = name;
        this.balance = balance;
        this.accountID = accountID;
        idCount += 1;
    }

    public void credit(int amount){
        balance = balance + amount;
    }


    public boolean debit(int amount){
        if (balance >= amount) {
            this.balance = balance - amount;
            return true;
        }
        return false;
    }

    public int getBalance(){
        return balance;
    }

    public String toString(){
        return(name +  " [" + type + ": " + accountID + "]");
    }

}

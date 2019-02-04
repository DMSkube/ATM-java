import java.util.ArrayList;


public class BankUser {
    public Account[] accounts;
    private String id;
    public String name;
    private String pin;

    private static ArrayList<BankUser> bankUsers = new ArrayList<BankUser>();

    public BankUser(String name, String id, String pin){
        this.name = name;
        this.id = id;
        this.pin = pin;
        this.accounts = new Account[3];
        bankUsers.add(this);
    }



    private String getName(){
        return name;
    }



    public static BankUser getUser(String id, String pin){
        String pinGiven = pin;
        String idGiven = id;
        for (int i = 0; i < bankUsers.size(); i++) {
            if (pinGiven.equals(bankUsers.get(i).pin) && idGiven.equals(bankUsers.get(i).id)) {
                return bankUsers.get(i);
            }
        }
        return null;
    }




    public Account[] getAccounts(){
        return accounts;
    }


    public String toString(){
        return(name + " [ID = " + id + ", PIN = " + pin + "]");
    }
}


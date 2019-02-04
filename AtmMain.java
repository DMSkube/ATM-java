public class AtmMain {

   public static void main(String[] args){
       Atm myAtm = new Atm(10000); // create ATM with ample money

       // Create users
       BankUser daniel = new BankUser("Daniel", "123", "abc");
       BankUser doug = new BankUser("Doug", "456", "def");
       BankUser prateek = new BankUser("Prateek", "789", "ghi");

       //Create accounts per user
       Account daniel1 = new Account("Checking", "Everyday Banking", "USFbank#101", 100);
       Account daniel2 = new Account("Savings", "Monthly Saving", "USFbank#102",250);
       Account daniel3 = new Account("Savings2", "Rainy Day Fund", "USFbank#103",500);
       // Add accounts to user profiles
       daniel.accounts[0] = daniel1;
       daniel.accounts[1] = daniel2;
       daniel.accounts[2] = daniel3;

       Account doug1 = new Account("Checking", "Basketball League Dues", "USFbank#201",100);
       Account doug2 = new Account("Savings", "Jordan-3's Fund", "USFbank#202",250);
       Account doug3 = new Account("Savings2", "Naismith Memorial Fund", "USFbank#203",500);
       doug.accounts[0] = doug1;
       doug.accounts[1] = doug2;
       doug.accounts[2] = doug3;

       Account prateek1 = new Account("Checking", "TA Money", "USFbank#301",100);
       Account prateek2 = new Account("Savings", "Venture Capital Money", "USFbank#302",250);
       Account prateek3 = new Account("Savings2", "Angel Investing Fund","USFbank#303", 500);
       prateek.accounts[0] = prateek1;
       prateek.accounts[1] = prateek2;
       prateek.accounts[2] = prateek3;

       System.out.println("");
       System.out.println("Welcome to the USF Bank.");

       System.out.println("Created the user " + daniel.toString());
       System.out.println("Created the user " + doug.toString());
       System.out.println("Created the user " + prateek.toString());

       // Open user menu, begin interactive portion
       while(myAtm.startSession()){
            while (true) {
                if (myAtm.performTransaction() == null) {break;}//performs transaction on loop, unless option 4 is selected(returns null), then inner loop is broken to repeat outer loop
            }
       }
   }
}

import java.util.Scanner;

public class BankingSystem2 {

   public static void main(String[] args) {

    String name;
    String currency = "PHP";
    double balance;
    int selection;
    
    Scanner scanner = new Scanner(System.in);


    System.out.print("Enter Account Name: ");
    name = scanner.nextLine();
    System.out.print("Enter Remaining Balance: ");
    balance = scanner.nextDouble();


    while(true) {

        System.out.println("\n");
        System.out.println("Choose an option ");
        System.out.println("---------------------------------");
        System.out.println("1: Display Information ");
        System.out.println("2: Deposit Funds ");
        System.out.println("3: Withdraw Funds ");
        System.out.println("4: Convert Funds ");
        System.out.println("5: Exit ");
    
        System.out.println("\n");
        System.out.println("---------------------------------");
        System.out.print("Enter your option: ");
        selection = scanner.nextInt();

        switch(selection) {

            case 0:
            System.out.println("---------------------------------");
            System.out.println("Invalid. Please try again.");
            System.exit(0);
            case 1:
            displayInfo(name,balance,currency);
            break; 
            case 2:
            balance = addFunds(balance);
            break; 
            case 3:
            balance = withdrawFunds(balance);
            break; 
            case 4:
            balance = convertFunds(balance);
                if(balance % 0.019 == 0) {
                    currency = "USD";
                } else if(balance % 0.024 == 0) {
                    currency = "CAD";
                }
            break;
            case 5:
            System.out.println("---------------------------------");
             System.out.println("Thank You For Using Our Services....");
             System.exit(0);
            
        }
        

    }
}


   public static void displayInfo(String name, double balance, String currency) {
       System.out.println("\n");
       System.out.println("---------------------------------");
       System.out.print("Name: " + name + " | Balance: " + currency + balance );
   }

   public static double addFunds(double initialAmount) {
        Scanner input = new Scanner(System.in);
        int amountAdd;
        System.out.println("\n");
        System.out.println("---------------------------------");
        System.out.print("Enter amount to deposit: ");
        amountAdd = input.nextInt();
        
        if(amountAdd<=0 || amountAdd<500) {
            System.out.println("---------------------------------");
            System.out.println("Error! Minimum amount should be atleast 500. Please try again. ");
            return initialAmount += amountAdd;
        } else {
            System.out.println("---------------------------------");
            System.out.println(amountAdd + " is added to your account");
            return initialAmount += amountAdd;
        }
   }

   public static double withdrawFunds(double initialAmount) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("---------------------------------");
        System.out.print("Enter amount to withdraw: ");
        int withdraw = input.nextInt();
        
        if(withdraw<=0 || withdraw<500) {
            System.out.println("---------------------------------");
            System.out.println("Error! Minimum amount should be atleast 500. Please try again. ");
        } else {
            System.out.println("---------------------------------");
            System.out.println(withdraw + " has been withdrawn successfully");
        }
        return initialAmount -= withdraw;
        

   }

   public static double convertFunds(double balance) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Select currency: ");
        System.out.println("1 - USD");
        System.out.println("2 - CAD");
        System.out.println("\n");
        System.out.print("Selection: ");
        int selection = input.nextInt();

        if(selection == 1) {
            balance *= 0.019;
            System.out.println("---------------------------------");
            System.out.println("Sucessfully converted to USD. Total US Dollars on the account is " + balance);
        } else if (selection == 2) {
            balance *= 0.024;
            System.out.println("---------------------------------");
            System.out.println("Sucessfully converted to CAD. Total Canadian Dollars on the account is " + balance);
        }
        return balance;
    }

}
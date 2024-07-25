import java.util.Scanner;
public class Account {
    
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    Account(String name, String id){
        customerID = id;
        customerName = name;
    }

    void deposit(int amount){
        if(amount!=0){
            previousTransaction = amount;
            balance  += amount;
        }
    }

    void withdraw(int amount){
        if(amount<=balance && amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited: "+ previousTransaction);
        }else if(previousTransaction < 0){
            System.out.println("Withdraw: "+ Math.abs(previousTransaction));
        }else{
            System.out.println("No Transaction Occurred");
        }
    }

    void calculateInterest(int years){
        double interestRate = .0125;
        double  newBalance = (balance * interestRate * years)+ balance;
        System.out.println("The current interest rate is "+ (100* interestRate));
        System.out.println("after "+ years + " years, your balance will be : " + newBalance);
    }

    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, "+ customerName + "!");
        System.out.println("Your ID, "+ customerID);
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make deposit");
        System.out.println("C. Withdraw money");
        System.out.println("D. View previous Transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do{
            System.out.println();
            System.out.println("Enter option");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option){
                case 'A':
                    System.out.println("#####################################");
                    System.out.println("Balance = $ " + balance);
                    System.out.println("#####################################");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter Amount to deposit:  ");
                    int amount1  =  sc.nextInt();
                    deposit(amount1);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter Amount to withdraw:  ");
                    int amount2  =  sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("#####################################");
                    getPreviousTransaction();
                    System.out.println("#####################################");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accured interest:  ");
                    int year  =  sc.nextInt();
                    calculateInterest(year);
                    System.out.println();
                    break;
                case 'F':
                    System.out.println("#########################################");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please enter A, B, C, D, E, F");
                    break;
            }
        }while(option!='F');
        System.out.println("Thankyou for banking with us!!!!!!!!!");
        sc.close();
    }
}

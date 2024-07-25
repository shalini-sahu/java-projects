import java.util.Scanner;
public class BankingApplication{

    public static void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name : ");
        String userName = sc.next();
        System.out.println("Enter user ID : ");
        String userID = sc.next();
        Account user = new Account(userName, userID);
        user.showMenu();
        sc.close();
        return;
    }
}
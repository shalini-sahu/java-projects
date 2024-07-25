package Email_Application;
import java.util.Scanner;

public class EmailApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name : ");
        String firstName = sc.next();
        System.out.println("Enter last name : ");
        String lastName = sc.next();
        Email user = new Email(firstName, lastName);
        user.showInfo();
        sc.close();
        return;
    }
    
}

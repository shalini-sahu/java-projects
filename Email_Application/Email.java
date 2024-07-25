package Email_Application;
import java.util.Scanner;

public class Email {
    
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 100;
    private int defaultPassLength = 10;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";

    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.department = setDepartment();
        this.password = ranPassword(defaultPassLength);
        email = firstName.toLowerCase()+ "_" + lastName.toLowerCase() + "@" + department + "." +companySuffix;
    }

    private String setDepartment(){
        System.out.println("Enter department \n1. Sales \n2. Account \n3. Development  \n0. none");
        Scanner  sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.close();
        if(choice==1){
            return "sales";
        }else if( choice == 2){
            return "acc";
        }else if( choice == 3){
            return "dev";
        }else{
            return "";
        }
    }

    private String ranPassword(int length){
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$&";
        char password[] = new char[length];
        for(int i =0;i<length;i++){
            int rand = (int)(Math.random()*passSet.length());
            password[i] = passSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
        return;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
        return;
    }

    public void setPassword(String password){
        this.password = password;
        return;
    }

    public int getMailboxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
        
    }

    public String getPassword(){
        return password;
    }

    public void showInfo(){
        System.out.println("Display Name: "+ firstName+" "+ lastName);
        System.out.println("Company Email: "+ email);
        System.out.println("Mailbox Capacity "+ mailBoxCapacity);
    }
}

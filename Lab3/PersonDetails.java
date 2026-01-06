import java.util.Scanner;

class Account{
    int acc_no = 0;
    int balance = 0;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account number: ");
        this.acc_no = sc.nextInt();
        System.out.print("Enter Balance: ");
        this.balance = sc.nextInt();
        System.out.print("\n");
    }

    void disp(){
        System.out.println("Account Number: "+this.acc_no);
        System.out.println("Balance: "+this.balance+"\n");
    }
}

class Person extends Account{
    String name;
    int aadhaar_no = 0;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Aadhaar Number: ");
        this.aadhaar_no = sc.nextInt();
        super.input();
    }

    void disp(){
        System.out.println("Name: "+this.name);
        System.out.println("Aadhaar Number: "+this.aadhaar_no);
        super.disp();
    }

}

public class PersonDetails {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        System.out.println("Enter Person Details:  ");
        p1.input();
        System.out.println("Enter Person Details:  ");
        p2.input();
        System.out.println("Enter Person Details:  ");
        p3.input();

        System.out.println("Displaying Details...  ");
        p1.disp();
        p2.disp();
        p3.disp();

    }
}
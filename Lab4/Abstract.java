import java.util.Scanner;

abstract class Student{
    int roll_no;
    int reg_no;

    void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        this.roll_no = sc.nextInt();

        System.out.print("Enter Registration Number: ");
        this.reg_no = sc.nextInt();
    }

    abstract void course();
}

class Kiitian extends Student{
    void course(){
        System.out.print("\n");

        System.out.println("Output - Roll Number: "+super.roll_no);
        System.out.println("Registration no - "+super.reg_no);
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }
}

public class Abstract{
    public static void main(String[] args){
        Kiitian s1 = new Kiitian();
        s1.getInput();
        s1.course();


        // 3. Using the equals method , demonstrate via a program how to compare 2 students for equality.


        Kiitian s2 = new Kiitian();

        // making them have same values ....
        s2.reg_no = s1.reg_no;
        s2.roll_no = s1.roll_no;

        System.out.println(s2.equals(s1));

        Kiitian kRef;

        kRef = s1;

        System.out.println(kRef.equals(s1));
    }
}




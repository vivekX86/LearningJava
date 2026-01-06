package Lab2;
import java.util.Scanner;

class Stu{
    String name;
    int rollNo;
    float CGPA;

    Stu(String n, int roll, float cgpa){
        this.name = n;
        this.rollNo = roll;
        this.CGPA = cgpa;
    }
}

public class students{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Students: ");
        int n = sc.nextInt();

        Stu[] studentsList = new Stu[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Roll.No: ");
            int roll = sc.nextInt();
            System.out.print("CGPA: ");
            float cgpa = sc.nextFloat();

            studentsList[i] = new Stu(name, roll, cgpa);
            System.out.println(" ");
        }

        // calculate lowest cgpa

        Stu lowestCgpa = studentsList[0];

        for (int i = 0; i < n; i++) {
            if(studentsList[i].CGPA < lowestCgpa.CGPA){
                lowestCgpa = studentsList[i];
            }
        }

        // display
        for (int i = 0; i < n; i++) {
            System.out.println("Name: "+studentsList[i].name+" Roll.No: "+studentsList[i].rollNo+" CGPA: "+studentsList[i].CGPA);
        }

        System.out.println(" ");
        System.out.println("Student with lowest cgpa is: "+lowestCgpa.name);


    }
}
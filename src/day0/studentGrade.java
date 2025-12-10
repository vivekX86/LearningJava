package day0;

import java.util.Scanner;

class StudentMarks{
    double marks;
    StudentMarks(double m){
        this.marks = m;
    }

    void result(){
        if(this.marks > 90){
            System.out.println("Grade O");
        } else if (this.marks > 80) {
            System.out.println("Grade E");
        } else if (this.marks > 70) {
            System.out.println("Grade A");
        }else if (this.marks > 60) {
            System.out.println("Grade B");
        }else if (this.marks > 50) {
            System.out.println("Grade C");
        } else {
            System.out.println("Bad -_-");
        }
    }
}

class studentGrade{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Marks: ");
        double marks = sc.nextInt();

        StudentMarks g1 = new StudentMarks(marks);

        g1.result();
    }
}

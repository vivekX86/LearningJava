package Lab6.Marketing;
import Lab6.General.employee;

import java.util.Scanner;

public class sales extends employee {
   public double tallowance(double base){
       double b = super.earnings(base);
       double allowance = (0.5*b);
       return b;
   }

   sales(String name, int empId){
       super(name, empId);
   }

   public static void main  (String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the employee Id: ");
       int empId = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter the employee name: ");
       String name = sc.nextLine();
       System.out.print("Enter the Basic Salary: ");
       int base = sc.nextInt();
       sales s = new sales(name, empId);

       double earnings = s.tallowance(base);

       System.out.print("The emp id os the employee is "+s.empid+"\nThe total earning is "+earnings);
   }
}

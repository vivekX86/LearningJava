package day0;
import java.util.*;

public class printDetails {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Branch: ");
        String branch = sc.nextLine();
        System.out.println("Enter Roll No: ");
        int roll = sc.nextInt();
        System.out.println("Enter Section: ");
        int section = sc.nextInt();

        System.out.println("Name: "+name+"\nRoll No: "+roll+"\nSection: "+section+"\nBranch: "+branch);
    }
}
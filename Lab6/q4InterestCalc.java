package Lab6;

import java.util.Scanner;

class Bank{
    double balance = 1000;
    static class InterestCalculator{
        static double calculate(int base, double rate, int time){
            return (base*rate*time)/100;
        }
    }

    static void Demonstrate() {
//        System.out.println(balance);
//        ERROR: java: non-static variable balance cannot be referenced from a static context

        System.out.println("Static nested class cannot access non-static members directly.");
    }
}

class q4InterestCalc{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you primary amount: ");
        int p = sc.nextInt();
        System.out.print("Enter Rate(per annum in %): ");
        double r = sc.nextInt();
        System.out.print("Enter the Time Period(in years): ");
        int t = sc.nextInt();
        double interest = Bank.InterestCalculator.calculate(p, r, t);
        System.out.println("Simple Interest: " + interest);

        Bank.Demonstrate();
    }
}
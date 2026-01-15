import java.util.Scanner;

interface SalaryInt{
    void earnings();
    void deductions();
    void bonus();
}

class Maanager implements SalaryInt{
    double basicSalary = 0;
    double deduction = 0;
    double earnings = 0;
    public void earnings(){
        earnings = basicSalary + (0.8*basicSalary) + (0.15*basicSalary);
        System.out.println("Earnings - "+earnings);
    }
    public void deductions(){
        deduction = basicSalary * (0.12);
        System.out.println("Deductions - "+deduction);
    }

    public void bonus(){}
}

class Substaff extends Maanager{
    double bonus;
    public void bonus(){
        bonus = 25000;
        System.out.print("Bonus - "+bonus);
    }
    Substaff(int base){
        super.basicSalary = base;
    }
}

class StaffManager{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Basic salary - ");
        int base = sc.nextInt();

        SalaryInt ref;

        ref = new Substaff(base);
        ref.earnings();
        ref.deductions();
        ref.bonus();
    }
}
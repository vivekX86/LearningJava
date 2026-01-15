import java.util.Scanner;

class lastDeposit{
    int day;
    int month;
    int year;

    lastDeposit(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }
}

abstract class Account {
    static int accountNumberIterator = 1;
    int account_number = 0;
    String account_type;
    String accountHolderName;
    double balance = 0;

    void checkBalance(){
        System.out.println("Current Account ["+this.accountHolderName+"'s] Balance is: "+this.balance);
    }

    Scanner sc = new Scanner((System.in));

    void deposit(){
        System.out.print("Enter the amount to be deposit to "+this.accountHolderName+"'s Account: ");
        int amount = sc.nextInt();
        this.balance = this.balance + amount;

        System.out.print("Enter the date (Day): ");
        int day = sc.nextInt();
        System.out.print("Enter the date (Month): ");
        int month = sc.nextInt();
        System.out.print("Enter the date (Year): ");
        int year = sc.nextInt();

        lastDeposit lastD = new lastDeposit(day,month,year);

        System.out.println(amount+" added to Account holder: "+this.accountHolderName+" on "+lastD.day+"/"+lastD.month+"/"+lastD.year);

    }

    abstract void withdraw();
}

class StandardAccount extends Account{
    StandardAccount(String name, double bal){
            super.account_number = Account.accountNumberIterator;
            Account.accountNumberIterator++;
            super.accountHolderName = name;
            super.account_type = "Standard";
            super.balance = bal;
        }

    void withdraw() {
        System.out.print("Enter the amount to withdraw from "+this.accountHolderName+"'s Account: ");
        int amount = sc.nextInt();

        if (amount > 5_00_000) {
            System.out.println("Withdrawal limit exceeded");
            return;
        }

        double penalty = 0;
        if (amount > 100000) {
            penalty = amount * 0.0005;
        }

        double totalDeduction = amount + penalty;

        if (totalDeduction > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= totalDeduction;
        System.out.println(amount+" was deducted form "+this.accountHolderName+"'s account \nCurrent Balance: "+super.balance);
    }
}

class PremiumAccount extends Account{
    PremiumAccount(String name, double bal){
        super.account_number = Account.accountNumberIterator;
        Account.accountNumberIterator++;
        super.accountHolderName = name;
        super.account_type = "Premium";
        super.balance = bal;
    }

    void withdraw() {
        System.out.print("Enter the amount to withdraw from "+this.accountHolderName+"'s Account: ");
        int amount = sc.nextInt();

        if (amount > 10_00_000) {
            System.out.println("Daily withdrawal limit exceeded");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println(amount+" was deducted form your account \nCurrent Balance: "+super.balance);
    }
}

class Startq1{
    public static void main(String[] args){
        StandardAccount sAcc = new StandardAccount("Vivek", 50000);
        System.out.println("Account Created with name: "+sAcc.accountHolderName+" and balance: "+sAcc.balance+" and Account is "+sAcc.account_type);
        PremiumAccount pAcc = new PremiumAccount("Apple", 45000);
        System.out.println("Account Created with name: "+pAcc.accountHolderName+" and balance: "+pAcc.balance+" and Account is "+pAcc.account_type);

        Account aRef;

        aRef = sAcc; aRef.deposit();
        aRef = pAcc; aRef.withdraw();
        aRef = sAcc; aRef.withdraw();
        aRef = pAcc; aRef.deposit();
        aRef = sAcc; aRef.checkBalance();
        aRef = pAcc; aRef.checkBalance();

    }
}
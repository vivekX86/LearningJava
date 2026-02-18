package Lab7;
import java.util.Scanner;

class NegativeNumberException extends Exception{
    private int num;
    NegativeNumberException(int n){
        num = n;
    }
    public String toString(){
        return ("Caught the exception \nException occurred: NegativeNumberException: number should be positive");
    }
}

class MyClass{
    void ProcessInput() throws NegativeNumberException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if(n<0){
            throw new NegativeNumberException(n);
        } else {
            System.out.print("Double Value: "+2*n);
        }
    }
}

public class ExceptionDemo3 {
    public static void main(String[] args){
        MyClass c = new MyClass();
        try {
            c.ProcessInput();
        } catch (NegativeNumberException e){
            System.out.print(e);
        }
    }
}

package Lab2;
import java.util.Scanner;

class Rectangle{
    float length;
    float breadth;
    float area;
    float parameter;

    void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length fo the Rectangle: ");
        this.length = sc.nextInt();
        System.out.print("Enter breadth fo the Rectangle: ");
        this.breadth = sc.nextInt();
    }

    void calculate(){
         this.area = this.length * this.breadth;
         this.parameter = 2*(this.length + this.breadth);
    }

    void display(){
        System.out.println("Area of Rectangle is: "+this.area+"\nParameter of Rectangle is: "+this.parameter);
    }
}

public class rect {
    public static void main(String[] args){
        Rectangle r1 = new Rectangle();

        r1.read();
        r1.calculate();
        r1.display();

    }
}
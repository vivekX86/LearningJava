package Lab1;
import java.util.Scanner;

class Box{
    float length;
    float width;
    float height;

    Box(float l, float w, float h){
        this.length = l;
        this.width = w;
        this.height = h;
    }

    float volume(){
        return this.height * this.width * this.length;
    }
}

public class boxDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        float len = sc.nextInt();
        System.out.print("Enter width: ");
        float wid = sc.nextInt();
        System.out.print("Enter height: ");
        float hei = sc.nextInt();

        Box b1 = new Box(len, wid, hei);

        System.out.println("Volume of the box is: " + b1.volume());

    }
}
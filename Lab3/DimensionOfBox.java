package Lab3;
import java.util.Scanner;

class twoD{
    float a, b;
    float cost = 0;
    twoD(float a, float b){
        this.a = a;
        this.b = b;

        cost = 40*(this.a * this.b);
    }
    public void displayCost(){
        System.out.println("The cost of sheet is: "+cost);
    }
}

class threeD extends twoD {
    float c;
    float cost = 0;

    threeD(float a, float b, float c){
        super(a,b);
        this.c = c;

        cost = 60*(super.a * super.b * this.c);
    }

    public void displayCost(){
        System.out.println("The cost of box is: "+cost);
    }
}

public class DimensionOfBox{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Select: \n1. Box \n2. Sheet \n");
        int option = sc.nextInt();

        System.out.println("Enter Dimensions: ");
        System.out.print("Length: ");
        int l = sc.nextInt();
        System.out.print("Breadth: ");
        int b = sc.nextInt();

        if(option == 1){
            System.out.print("Height: ");
            int h = sc.nextInt();
            threeD box = new threeD(l,b,h);
            box.displayCost();
        } else if (option == 2) {
            twoD sheet = new twoD(l,b);
            sheet.displayCost();
        } else {
            System.out.println("Invalid Option!");
        }

    }
}

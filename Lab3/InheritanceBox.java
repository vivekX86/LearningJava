package Lab3;
import java.util.Scanner;

class plate{
    int length;
    int width;

    void display(){
        System.out.println("Length: "+this.length+" and Width: "+this.width);
    }

    plate(int l, int w){
        System.out.println("Plate Constructor Called");
        this.length = l;
        this.width = w;
        display();
    }
}

class box extends plate{
    int height;

    void display(){
        System.out.println("Length: "+this.length+", Width: "+this.width+" and Height: "+this.height);
    }

    box(int l, int w, int h){
        super(l,w);
        System.out.println("Box Constructor Called");
        this.height = h;
        display();
    }
}

class woodBox extends box{
    int thick;
    woodBox(int l, int w, int h, int t){
        super(l,w,h);
        System.out.println("WoodBox Constructor Called");
        this.thick = t;
    }

    public void display(){
        System.out.println("Length: "+this.length+", Width: "+this.width+", Height: "+this.height+" and Thickness: "+this.thick);
    }
}


public class InheritanceBox{
    public static void main(String[] args){
        System.out.println("Enter dimensions: ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Length: ");
        int l = sc.nextInt();
        System.out.print("Width: ");
        int w = sc.nextInt();
        System.out.print("Height: ");
        int h = sc.nextInt();
        System.out.print("Thickness: ");
        int t = sc.nextInt();

        woodBox b = new woodBox(l,w,h,t);

        b.display();
    }
}
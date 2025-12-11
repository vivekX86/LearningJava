package Lab1;

class Obj{
    static int count = 0;
    Obj(){
        count++;
    }
}

public class numOfObjects{
    public static void main(String[] args){
        Obj o1 = new Obj();
        Obj o2 = new Obj();
        Obj o3 = new Obj();

        System.out.println("Number of created Objects is: "+Obj.count);
    }
}
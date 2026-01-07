class Fruit{
    void show(){
        System.out.println("Show method called from FRUIT CLASS");
    }
    Fruit(){
        System.out.println("FRUIT Constructor called");
    }
}

class Cherry extends Fruit{
    void show(){
        System.out.println("Show method called from CHERRY CLASS");
    }
    Cherry(){
        System.out.println("CHERRY Constructor called");
    }
}

class Banana extends Fruit{
    void show(){
        System.out.println("Show method called from BANANA CLASS");
    }
    Banana(){
        System.out.println("BANANA Constructor called");
    }
}


class FruitClass{
    public static void main(String[] args){
        Fruit f = new Fruit();
        Cherry c = new Cherry();
        Banana b = new Banana();

        Fruit fRef;

        fRef = f; fRef.show();
        fRef = c; fRef.show();
        fRef = b; fRef.show();
    }
}


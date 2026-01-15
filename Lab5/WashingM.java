interface Motor{
    int CAPACITY = 16;
    void run();
    void consume();
}

class WashingMachine implements Motor{
    public void run() {
        System.out.println("Machine is running");
    }
    public void consume() {
        System.out.println("Machine is consuming");
    }
}

class WashingM{
    public static void main(String[] args){
        Motor mRef;
        mRef = new WashingMachine();

        mRef.run();
        mRef.consume();
        System.out.println("Capacity of the motor is "+Motor.CAPACITY);
    }
}
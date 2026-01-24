package Lab6;

interface Greeting{
    void sayHello();
}

class q5Greeting{
    public static void main(String[] args){
        Greeting greet = new Greeting() {
            public void sayHello() {
                System.out.println("Hello");
            }
        };

        greet.sayHello();
    }
}
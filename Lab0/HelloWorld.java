class Box{
    double height;
    double width;
    double depth;

    Box(int h, int w, int d){
        this.height = h;
        this.width = w;
        this.depth = d;
    }

    double getVol(){
        return this.height * this.width * this.depth;
    }

}
class HelloWorld {
    public static void main(String args[]) {

        System.out.println("Hello World!");

        //      class EXAMPLE

        Box myBox = new Box(2,3,4);
        System.out.println("Volume is: "+ myBox.getVol() );

    }
}
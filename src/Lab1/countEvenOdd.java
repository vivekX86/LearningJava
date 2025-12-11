package Lab1;

public class countEvenOdd{
    public static void main(String args[]){
        if(args.length < 10){
            System.out.println("Enter atleast 10 numbers");
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(args[i]);

            if(num%2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even numbers is: "+evenCount+"\nNumber of odd number is "+oddCount);

    }
}

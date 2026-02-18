package Lab7;

import java.util.Scanner;

class ExceptionDemo1 {
    public static void main(String[] args){
        int[] arr = new int[4];
        System.out.println("Enter the number(Array size is 4): ");
        Scanner sc = new Scanner(System.in);
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();

        try {
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception in thread \"main\" "+e.toString());
        }
    }
}
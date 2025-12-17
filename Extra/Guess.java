package Extra;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = (int)(Math.random() * 1000) + 1;

        System.out.println("Guess the number between 1 - 1000 (10 chances)");
        int chance = 10;

        while (chance > 0) {
            int guess = sc.nextInt();

            if (guess > number) {
                System.out.println("It's less");
            } else if (guess < number) {
                System.out.println("It's more");
            } else {
                System.out.println("FOUND IT! :)");
                break;
            }
            chance--;
            System.out.println("Chances left: " + chance);
        }
        System.out.println("The number was "+number+" :)");

        sc.close();
    }
}

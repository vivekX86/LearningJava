package lab8;

import java.util.Scanner;

public class StringExample{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n------ STRING MENU ------");
            System.out.println("1. Change the case of the string");
            System.out.println("2. Reverse the string");
            System.out.println("3. Compare two strings");
            System.out.println("4. Insert one string into another string");
            System.out.println("5. Convert string to upper and lower case");
            System.out.println("6. Find character position in string");
            System.out.println("7. Check palindrome");
            System.out.println("8. Count words, vowels and consonants");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter a String: ");
                    changeCaseAndReverse(sc.nextLine());
                    break;

                case 2:
                    System.out.println("a) Without using predefined function");
                    System.out.println("b) Using predefined function");
                    char subChoice = sc.next().charAt(0);
                    sc.nextLine();

                    System.out.print("Enter a String: ");
                    String revStr = sc.nextLine();

                    switch (subChoice) {
                        case 'a':
                            reverseString(revStr);
                            break;

                        case 'b':
                            System.out.println("The string after reversing is: "
                                    + reverseStringUsingFunction(revStr));
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                    break;

                case 3:
                    System.out.print("Enter first string: ");
                    String s1 = sc.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = sc.nextLine();
                    compareString(s1, s2);
                    break;

                case 4:
                    System.out.print("Enter main string: ");
                    String mainStr = sc.nextLine();
                    System.out.print("Enter string to insert: ");
                    String insStr = sc.nextLine();
                    oneStrIntoAnother(insStr, mainStr);
                    break;

                case 5:
                    System.out.print("Enter a String: ");
                    showCases(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter a String: ");
                    String str = sc.nextLine();
                    System.out.print("Enter a Character: ");
                    char ch = sc.next().charAt(0);
                    sc.nextLine();
                    findCharPosition(str, ch);
                    break;

                case 7:
                    System.out.print("Enter a String: ");
                    String pal = sc.nextLine();
                    if (palindromeOrNot(pal)) {
                        System.out.println("Entered string is palindrome");
                    } else {
                        System.out.println("Entered string is not palindrome");
                    }
                    break;

                case 8:
                    System.out.print("Enter a String: ");
                    countWords(sc.nextLine());
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);
    }


    static String reverseStringUsingFunction(String str){
        String res = null;
        StringBuffer sb = new StringBuffer(str);
        res = sb.reverse().toString();
        return res;
    }

    static void reverseString(String str){
        String result = "";
        int start = 0, end = str.length(), destoffset = 0;
        char buf[] = new char[end - start];
        str.getChars(start, end, buf, destoffset);
        for (int i = str.length() - 1; i >= 0; i--) {
            result += buf[i];
        }
        System.out.println("The string after reversing is: " + result+"\n");
    }

    static void changeCaseAndReverse(String str){
        String res = null;
        res = str.toUpperCase();
        System.out.println("The string after changing the case is: " + res);
//        reverseStringUsingFunction(str);
        reverseString(str);
    }

    static void compareString(String str1, String str2){
        int res = str2.compareTo(str1);
        System.out.println("The difference between ASCII value is: "+res+"\n");
    }

    static void oneStrIntoAnother(String s1, String s2){
        String res = "";
        res = s2+" "+s1;
        System.out.println("he string after insertion is: "+res+"\n");
    }

    static void showCases(String str){
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase()+"\n");
    }

    static void findCharPosition(String s1, char s2){
        int checked = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2){
                System.out.println("Position of entered character: "+(i+1));
                checked++;
            }
        }
        if(checked == 0){
            System.out.println("Entered character is not present");
        }
    }

    static boolean palindromeOrNot(String str){
        String rev = reverseStringUsingFunction(str);
        return rev.equals(str);
    }

    static void countWords(String str){
        int wordC = 0;
        int vowelC = 0;
        int consonantsC = 0;

        char[] vow = {'a','e','i','o','u'};
        char[] chars = str.toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if( (i == 0 && chars[i] != ' ') || (i > 0 && chars[i] != ' ' && chars[i-1] == ' ') ){
                wordC++;
            }

            if(chars[i] == ' ') continue;

            boolean isVowel = false;
            for (int k = 0; k < vow.length; k++) {
                if(chars[i] == vow[k]){
                    vowelC++;
                    isVowel = true;
                    break;
                }
            }

            if(!isVowel && chars[i] >= 'a' && chars[i] <= 'z'){
                consonantsC++;
            }
        }

        System.out.println("No. of words: " + wordC);
        System.out.println("No. of vowels: " + vowelC);
        System.out.println("No. of consonants: " + consonantsC);
    }


}
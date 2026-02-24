package Lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class FileHandlingDemo4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of the file - ");
        String filename = sc.nextLine();

        int characters = 0;
        int words = 0;
        int lines = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                lines = lines + 1;

                characters += line.length();

                boolean insideWord = false;   // tells if we are currently in a word

                for (int i = 0; i < line.length(); i++) {

                    char ch = line.charAt(i);

                    if (ch != ' ' && ch != '\t') {

                        if (insideWord == false) {
                            words = words + 1;
                            insideWord = true;
                        }

                    } else {
                        insideWord = false;
                    }
                }
            }

            br.close();

            System.out.println("No. of characters - " + characters);
            System.out.println("No. of lines - " + lines);
            System.out.println("No. of words - " + words);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}

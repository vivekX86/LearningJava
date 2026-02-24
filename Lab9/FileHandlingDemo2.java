package Lab9;

import java.io.*;
import java.util.Scanner;

public class FileHandlingDemo2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the source file name: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter the destination file name: ");
        String destFile = sc.nextLine();

        /* -------- Character Stream -------- */
        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(destFile)) {

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }

            System.out.println("File Copied (Character Stream)");

        } catch (Exception e) {
            System.out.println(e);
        }

        /* -------- Byte Stream -------- */
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream("byte_" + destFile)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }

            System.out.println("File Copied (Byte Stream)");

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}

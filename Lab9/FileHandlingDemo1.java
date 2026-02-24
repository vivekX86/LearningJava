package Lab9;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class FileHandlingDemo1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FileWriter fw;
        FileReader fr;
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter RollNo: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        String Line = name+", "+roll+", "+subject+", "+marks;

        String fileName = "";
        System.out.print("Enter File Name: ");
        fileName = sc.nextLine();

        try{
            fw = new FileWriter(fileName);
            fr = new FileReader(fileName);

            fw.write(Line+"\n");
            fw.close();

            //READ

            String data = "";
            int ch;
            while ((ch = fr.read()) != -1) {
                data += (char) ch;
            }

            System.out.print("OUTPUT: "+data);

        } catch (Exception e) {
            System.out.print("ERROR: "+e.toString());
        }

    }
}
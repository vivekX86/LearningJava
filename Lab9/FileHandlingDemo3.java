package Lab9;

import java.io.FileInputStream;

public class FileHandlingDemo3 {
    public static void main(String[] args){
        String file1 = "file1.bin";
        String file2 = "file2.bin";

        try{
            FileInputStream fis1 = new FileInputStream(file1);
            FileInputStream fis2 = new FileInputStream(file2);

            int byte1, byte2;
            int pos = 0;
            boolean isSame = true;

            while (true){
                byte1 = fis1.read();
                byte2 = fis2.read();
                pos++;

                if(byte1 == -1 && byte2 == -1){
                    break;
                }

                if(byte1 != byte2){
                    System.out.println("Two files are not equal: byte position at which two files differ is " + pos);
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                System.out.println("Two files are equal");
            }

            fis1.close();
            fis2.close();

        } catch (Exception e) {
            System.out.print("ERROR: "+e.toString());
        }
    }
}

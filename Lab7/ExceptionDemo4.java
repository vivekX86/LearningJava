package Lab7;
import java.util.Scanner;

class HrsException extends Exception{
    public String toString(){
        return "Exception occurred:  InvalidHourException:hour is not greater than 24\n";
    }
}

class MinException extends Exception{
    public String toString(){
        return "Exception occurred:  InvalidMinuteException:hour is not greater than 60\n";
    }
}

class SecException extends Exception{
    public String toString(){
        return "Exception occurred:  InvalidSecondException:hour is not greater than 60\n";
    }
}

class Time{
    int hours, minutes, seconds;

    void takeTime() throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hours: ");
        hours = sc.nextInt();
        System.out.print("Enter Minutes: ");
        minutes = sc.nextInt();
        System.out.print("Enter Seconds: ");
        seconds = sc.nextInt();

        String errors = "";

        // check all conditions first
        if(hours>24 || hours<0)
            errors += new HrsException();

        if(minutes>60 || minutes<0)
            errors += new MinException();

        if(seconds>60 || seconds<0)
            errors += new SecException();

        // throw once after checking everything
        if(!errors.equals(""))
            throw new Exception(errors);

        System.out.println("Correct Time-> "+hours+":"+minutes+":"+seconds);
    }
}

public class ExceptionDemo4 {
    public static void main(String[] args){
        Time t = new Time();
        try{
            t.takeTime();
        }
        catch(Exception e){
            System.out.println("Caught the exception");
            System.out.print(e.getMessage());
        }
    }
}

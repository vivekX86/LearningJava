import java.util.Scanner;

interface Employee{
    void getDetails();
}

interface Manager extends Employee{
    void getDeptDetails();
}

class Head implements Manager{
    String employeeName;
    int employeeId;
    int departmentId;
    String departmentName;
    public void getDeptDetails() {
        System.out.println("Department ID - "+departmentId);
        System.out.println("Department Name - "+departmentName);
    }

    public void getDetails() {
        System.out.println("Employee ID - "+employeeId);
        System.out.println("Employee Name - "+employeeName);
        getDeptDetails();
    }

    Head(String name, int eId, String dName, int dId){
        this.employeeName = name;
        this.employeeId = eId;
        this.departmentName = dName;
        this.departmentId = dId;
    }
}

public class EmplInt{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Employee eRef;


        System.out.print("Employee ID - ");
        int eId = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee Name - ");
        String eName = sc.nextLine();
        System.out.print("Department ID - ");
        int dId = sc.nextInt();
        sc.nextLine();
        System.out.print("Department Name - ");
        String dName = sc.nextLine();

        eRef = new Head(eName, eId, dName, dId);

        System.out.print("\n");

        eRef.getDetails();

    }
}
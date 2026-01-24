package Lab6.General;

public class employee {
    protected int empid;
    private String ename;

    public double earnings(double base){
        return base + (base*0.8) + (base*.15) ;
    }

    public employee(String name, int empid){
        this.empid = empid;
        this.ename = name;
    }
}

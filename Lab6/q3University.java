package Lab6;

class University{
    String universityName;
    String location;
    class Department{
        String deptName;
        String hodName;

        void printParentClassVariables(){
            System.out.println("University Name: " + universityName);
            System.out.println("Location: " + location);
            System.out.println("Department Name: " + deptName);
            System.out.println("HOD Name: " + hodName);
        }
    }
}

class q3University{
    public static void main(String[] args){
        University u = new University();
        University.Department d = u.new Department();
        d.printParentClassVariables();
    }
}

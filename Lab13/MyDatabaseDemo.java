package Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MyDatabaseDemo {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cse7",
                    "root",
                    "kiit"
            );
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM student");

            while (res.next()) {
                System.out.println(res.getString("roll") + " | " + res.getString("name"));
            }
        }catch(Exception e){
            System.out.print("ERROR: "+e.toString());
        }
    }
}

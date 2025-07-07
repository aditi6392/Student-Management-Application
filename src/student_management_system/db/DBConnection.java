package student_management_system.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="aditi123";
            String url="jdbc:mysql://localhost:3306/students?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            con= DriverManager.getConnection(url,user,pass);
        }
        catch (Exception ex){
            ex.printStackTrace();


        }
        return con;
    }

}

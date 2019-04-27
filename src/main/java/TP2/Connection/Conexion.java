package TP2.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TP2","root","234C09d");

        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}

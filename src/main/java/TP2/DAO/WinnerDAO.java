package TP2.DAO;

import TP2.Connection.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WinnerDAO {

    public void save(String name, String word){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("insert into winners(name,word) values(?,?)");

            stmt.setString(1, name);
            stmt.setString(2,word);
            stmt.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally {

            try{
                if(!conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if(!stmt.isClosed()){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }
}

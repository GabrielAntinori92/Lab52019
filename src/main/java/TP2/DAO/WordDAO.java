package TP2.DAO;

import TP2.Connection.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class WordDAO {

    Random dado;

    public WordDAO(){
        this.dado = new Random();
    }

    public String selectWord(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectsql = "select word from words where id = ?";
        String result = "";

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(selectsql);
            stmt.setInt(1,selectRandomWordId());

            rs = stmt.executeQuery();

            if(rs.next()){
                result = rs.getString("word");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(!conn.isClosed()){
                    conn.close();
                }

                if(!stmt.isClosed()){
                    stmt.close();
                }

                if(!rs.isClosed()){
                    rs.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }

    private int selectRandomWordId(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = -1;
        int max = -1;
        String sqlqry = "select max(id) as id from words";

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlqry);

            rs = stmt.executeQuery();

            if(rs.next()){
                max = rs.getInt("id");
            }

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
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if(!rs.isClosed()){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        id = dado.nextInt(max + 1);

        return id;
    }
}

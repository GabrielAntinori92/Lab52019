package TorneoFrescas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GanadorDao {
    public void guardaGanador(String name, int resistencia_total){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("insert into ganadores(nombre,resistencia_final) values(?,?)");

            stmt.setString(1,name);
            stmt.setInt(2,resistencia_total);
            stmt.execute();

        }catch(Exception e){

            e.printStackTrace();

        }finally{
            if(conn != null){

                try{

                    conn.close();

                }catch (SQLException e){

                    e.printStackTrace();
                }
            }

            if(stmt != null){

                try{
                    stmt.close();
                }catch (SQLException e){

                    e.printStackTrace();

                }
            }
        }
    }
}

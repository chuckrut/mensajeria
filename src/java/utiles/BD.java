/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utiles;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class BD {
    public static Connection conectar() throws SQLException{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //hay que importar la librería JDBC
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mensajeria","root","");
        return conn;
    }
    
    public static void desconectar(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception e){}
        }
    }
}

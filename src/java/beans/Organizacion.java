
package beans;

import java.io.*;
import java.sql.*;
import java.util.*;
import utiles.BD;
/**@author Admin*/
public class Organizacion implements Serializable{
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados= new LinkedList();
        Connection conexion = null;
        try{
            conexion = BD.conectar();
            PreparedStatement consulta=conexion.prepareStatement(
                    "SELECT id, nick, nombre, apellidos, departamento FROM empleados;");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()){
                Empleado empleado = new Empleado();
                empleado.setId(resultado.getInt("id"));
                empleado.setNick(resultado.getString("nick"));
                empleado.setNombre(resultado.getString("nombre"));
                empleado.setApellidos(resultado.getString("apellidos"));
                empleado.setDepartamento(resultado.getString("departamento"));
                empleados.add(empleado);
            }
        }catch (SQLException e) {
            System.err.println("getEmpleados: " +e.getMessage());
        } finally {
            BD.desconectar(conexion);
        }
        return empleados;
    }
}

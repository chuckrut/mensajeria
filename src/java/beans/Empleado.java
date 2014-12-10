/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import utiles.BD;
import java.sql.*;
/**
 *
 * @author Jesus
 */
public class Empleado implements java.io.Serializable{
    private int id;
    private String nick;
    private String nombre;
    private String apellidos;
    private String departamento;
    private boolean validado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public boolean getValidado() {
        return validado;
    }
    
    public void setValidado(boolean validado){
        this.validado=validado;
    }
    /* Metodo para validar un usuario.
     * Comprueba usuario y password en la BD.
     * Si son correctas pone validado a true y establece las demás propiedades, sino pone validado a false.
     * @param password
    */
    public void setPassword(String password){
        Connection conexion =null;
        try{
            conexion = BD.conectar();
            PreparedStatement consulta= conexion.prepareStatement(
                    "select * from empleados where nick=?");
            consulta.setString(1, nick);
            ResultSet resultado= consulta.executeQuery();
            //Si existe empleado
            if (resultado.next()) {
                if (resultado.getString("password").equals(password)) {
                    validado=true;
                    id=resultado.getInt("Id");
                    nombre=resultado.getString("Nombre");
                    apellidos=resultado.getString("Apellidos");
                    departamento=resultado.getString("Departamento");
                }
            }
        }catch(SQLException e){System.err.println("Empleado.serPassword : "+e.getMessage());
        }finally{BD.desconectar(conexion);}
    }
}

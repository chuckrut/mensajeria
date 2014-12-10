/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;
import utiles.BD;

/** @author Admin*/
public class Mensaje implements Serializable {

    private int id;

    private String nombre;

    private String apellidos;

    private String ocupacion;

    private String email;

    private int idEmpleado;

    private String mensaje;

    private String ip;

    private Date fechaYhora;

    private String error;

    /**
     * Get the value of fechaYhora
     *
     * @return the value of fechaYhora
     */
    public Date getFechaYhora() {
        return fechaYhora;
    }

    /** Set the value of fechaYhora
     * @param fechaYhora new value of fechaYhora*/
    public void setFechaYhora(Date fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    /** Get the value of ip
     * @return the value of ip*/
    public String getIp() {
        return ip;
    }

    /** Set the value of ip
     * @param ip new value of ip*/
    public void setIp(String ip) {
        this.ip = ip;
    }

    /** Get the value of mensaje
     * @return the value of mensaje*/
    public String getMensaje() {
        return mensaje;
    }

    /** Set the value of mensaje
     * @param mensaje new value of mensaje*/
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /** Get the value of idEmpleado
     * @return the value of idEmpleado*/
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /** Set the value of idEmpleado
     * @param idEmpleado new value of idEmpleado*/
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /** Get the value of email
     * @return the value of email*/
    public String getEmail() {
        return email;
    }

    /** Set the value of email
     * @param email new value of email*/
    public void setEmail(String email) {
        this.email = email;
    }

    /** Get the value of ocupacion
     * @return the value of ocupacion*/
    public String getOcupacion() {
        return ocupacion;
    }

    /** Set the value of ocupacion
     * @param ocupacion new value of ocupacion*/
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /** Get the value of apellidos
     * @return the value of apellidos*/
    public String getApellidos() {
        return apellidos;
    }

    /** Set the value of apellidos
     * @param apellidos new value of apellidos*/
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /** Get the value of nombre
     * @return the value of nombre*/
    public String getNombre() {
        return nombre;
    }

    /** Set the value of nombre
     * @param nombre new value of nombre*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Get the value of id
     * @return the value of id*/
    public int getId() {
        return id;
    }

    /**Set the value of id
     * @param id new value of id*/
    public void setId(int id) {
        this.id = id;
    }
    
    /** Get the value of error
     * @return the value of error*/
    public String getError(){
        return error;
    }
    
    /**Set the value of error
     * @param error new value of id*/
    public void setError(String error){
        this.error=error;
    }
    /**Guarda el mensaje en la base de datos
     *@param caramelito Si es true, se guarda el mensaje
     * @throws java.lang.Exception*/
    public void setGuardar(boolean caramelito) throws Exception{
        if(caramelito){
            registrar();
        }
    }
    private void registrar() /*throws Exception*/{
        Connection conexion = null;
        try{
            conexion=BD.conectar();
            PreparedStatement insercion = conexion.prepareStatement(
                    "INSERT INTO mensajes values(0, ?, ?, ?, ?, ?, ?, ?, null)");
            insercion.setString(1, nombre);
            insercion.setString(2, apellidos);
            insercion.setString(3, ocupacion);
            insercion.setString(4, email);
            insercion.setInt(5, idEmpleado);
            insercion.setString(6, mensaje);
            insercion.setString(7, ip);
            insercion.execute();
            insercion.setTimestamp(8, new Timestamp(fechaYhora.getTime()));
        }catch(SQLException e){
            System.err.println("Mensaje.registrar: "+e.getMessage());
            error="Se ha producido un error al guardar el mensaje";
        }finally{BD.desconectar(conexion);}
    }
}

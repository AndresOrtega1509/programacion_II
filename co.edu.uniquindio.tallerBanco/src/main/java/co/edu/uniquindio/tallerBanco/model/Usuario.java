package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.model.Banco;

public class Usuario {

    private String nombre;
    private String direccion;
    private String cedula;
    private String correo;
    private String contrasena;
    Banco ownedByBanco;

    /*Constructor*/

    public Usuario() {
    }

    public Usuario(String nombre, String direccion, String cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /*Getters and Setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    public String obtenerInformacion(){
        String informacion = "";
        informacion = informacion +
                "Nombre: " + getNombre() + "\n" +
                "Direccion: " + getDireccion() + "\n" +
                "Cedula: " + getCedula() + "\n" +
                "Correo: " + getCorreo() + "\n" +
                "Contraseña: "+ getContrasena() + "\n";

        return informacion;
    }
}



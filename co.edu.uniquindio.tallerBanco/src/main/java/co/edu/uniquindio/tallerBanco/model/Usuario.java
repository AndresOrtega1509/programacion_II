package co.edu.uniquindio.tallerBanco.model;

public class Usuario {

    /**
     * Atributos de clase usuario
     */
    private String nombre;
    private String direccion;
    private String cedula;
    private String correo;
    private String contrasena;

    /**
     * Variable para relacionar padre
     */
    Banco ownedByBanco;

    /**
     * Constructor vacío
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros
     * @param nombre
     * @param direccion
     * @param cedula
     * @param correo
     * @param contrasena
     */
    public Usuario(String nombre, String direccion, String cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Getters y Setters atributos de clase usuario
     * @return
     */
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

    /**
     * Getters y Setters de variable para relacionar padre
     */
    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    /**
     * To String clase usuario
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
package co.edu.uniquindio.tallerBanco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombre;
    private String direccion;
    private String telefono;

    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Cuenta> listaCuentas = new ArrayList<>();

    /*Constructor*/

    public Banco() {
    }

    public Banco(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }


    public void crearUsuario(String nombre, String direccion, String cedula, String correo, String contrasena) {

        int resultadoBusqueda = devolverPosicionUsuario(cedula);

        if (resultadoBusqueda == -1) {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setCedula(cedula);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            getListaUsuarios().add(usuario);
            System.out.println("Usuario creado exitosamente");

        } else {
            System.out.println("El usuario ya esta creado en el sistema");
        }

    }

    public void crearCuenta(int saldo) {

        Cuenta cuenta = new Cuenta();
        double numeroCuenta = cuenta.generarNumeroCuenta();
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setSaldo(saldo);
        getListaCuentas().add(cuenta);
    }

    public List<Usuario> obtenerUsuarios() {
        return  getListaUsuarios();
    }

    public List<Cuenta> obtenerCuentas() {
        return getListaCuentas();
    }

    private int devolverPosicionUsuario(String cedula) {

        int posicion = -1;
        boolean bandera = false;
        for (int i = 0; i < listaUsuarios.size() && bandera == false; i++) {
            if (listaUsuarios.get(i).getCedula().equalsIgnoreCase(cedula)) {
                bandera = true;
                posicion = i;
            }
        }
        return posicion;

    }

    public void eliminarUsuario(String cedula) {

        for(Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                getListaUsuarios().remove(usuario);
                break;
            }
        }

    }

    public void actualizarUsuario(String cedula, String nombre, String direccion, String correo, String contrasena) {

        for (Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                usuario.setNombre(nombre);
                usuario.setDireccion(direccion);
                usuario.setCorreo(correo);
                usuario.setContrasena(contrasena);
                break;
            }
        }
    }
}

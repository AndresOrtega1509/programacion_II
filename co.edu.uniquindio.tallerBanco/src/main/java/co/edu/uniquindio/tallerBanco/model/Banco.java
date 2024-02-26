package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Banco {

    private String nombre;
    private String direccion;
    private String telefono;
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Cuenta> listaCuentas = new ArrayList<>();

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

    public void crearCuenta(String cedula, int saldo) {

        Cuenta cuenta = new Cuenta();
        String cuentaUnico = generarNumeroCuentaUnico();
        cuenta.setNumeroCuenta(cuentaUnico);
        cuenta.setSaldo(saldo);

        Usuario usuario = obtenerUsuario(cedula);

        if (usuario != null){
            cuenta.setUsuarioAsociado(usuario);
        }
        getListaCuentas().add(cuenta);
    }

    private Usuario obtenerUsuario(String cedula) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getCedula().equals(cedula)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    private String generarNumeroCuentaUnico() {

        Cuenta cuenta = new Cuenta();
        String numeroCuenta;

        do {
            numeroCuenta = cuenta.generarNumeroCuenta();
        }while (verificarNumeroCuenta(numeroCuenta));

        return numeroCuenta;
    }

    private boolean verificarNumeroCuenta(String numeroCuenta) {
        boolean bandera = false;
        for (Cuenta cuenta: listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)){
                bandera = true;
            }
        }
        return bandera;
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

    public void realizarTransferencia(String numeroCuentaRemitente, String numeroCuentaDestinatario, double monto, Categoria categoria) {

        Cuenta cuentaRemitente = obtenerNumeroCuenta(numeroCuentaRemitente);
        Cuenta cuentaDestinatario = obtenerNumeroCuenta(numeroCuentaDestinatario);

        if (cuentaRemitente != null && cuentaDestinatario != null && revisarSaldo(numeroCuentaDestinatario, monto)){

            Transaccion transaccionRemitente = new Transaccion(cuentaRemitente, cuentaDestinatario,monto, categoria, new Date(2023,5,3), TipoTransaccion.SALIDA);
            cuentaRemitente.getListaTransacciones().add(transaccionRemitente);
            transferir(cuentaRemitente, monto);
            Transaccion transaccionDestinatario = new Transaccion(cuentaRemitente,cuentaDestinatario, monto, categoria, new Date(2023,5,3), TipoTransaccion.ENTRADA);
            cuentaDestinatario.getListaTransacciones().add(transaccionDestinatario);
            depositar(cuentaDestinatario, monto);

        }
    }

    private void transferir(Cuenta cuentaRemitente, double monto) {

        double saldoRemitente = cuentaRemitente.getSaldo() - monto - 200;

        cuentaRemitente.setSaldo(saldoRemitente);
    }

    private void depositar(Cuenta cuentaDestinatario, double monto) {

        double saldoDestinatario = cuentaDestinatario.getSaldo() + monto;

        cuentaDestinatario.setSaldo(saldoDestinatario);

    }

    private boolean revisarSaldo(String numeroCuentaDestinatario, double monto) {

        boolean saldoSuficiente = false;

        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuentaDestinatario)){
                double saldo = cuenta.getSaldo();

                if (saldo > monto){
                    saldoSuficiente = true;
                }
            }
        }
        return saldoSuficiente;
    }


    private Cuenta obtenerNumeroCuenta(String numeroCuentaRemitente) {

        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuentaRemitente)){
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }

    public void consultarSaldo(String cedula, String contrasena) {

        String saldoEncontrado = "Usuario no encontrado";

        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getUsuarioAsociado().getCedula().equalsIgnoreCase(cedula) &&
                    cuenta.getUsuarioAsociado().getContrasena().equalsIgnoreCase(contrasena)) {

                saldoEncontrado = String.valueOf(cuenta.getSaldo());

                if (cuenta.getListaTransacciones().isEmpty()){
                    System.out.println("El usuario no tiene registradas transacciones");
                }else {
                    saldoEncontrado += "\n" + "Transacciones asociadas: "+ "\n" + cuenta.getListaTransacciones();
                }
            }

        }

        System.out.println("El saldo disponible en la cuenta es de: "+ saldoEncontrado +"\n");

    }

    public Transaccion consultarTransaccionFecha(Date fechaConsulta) {
        Transaccion transaccionEncontrada = null;
        for (Cuenta cuenta : listaCuentas ){
            for (Transaccion transaccion : cuenta.getListaTransacciones()){
                if (transaccion.getFecha() == fechaConsulta){
                    transaccionEncontrada = transaccion;
                }
            }
        }
        return transaccionEncontrada;

    }
}

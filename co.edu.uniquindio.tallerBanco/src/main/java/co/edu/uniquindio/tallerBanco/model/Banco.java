package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Objects;

public class Banco {

    /**
     * Atributos Clase Banco
     */
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * ArrayList Relacionadas de la Clase
     */
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Cuenta> listaCuentas = new ArrayList<>();

    /**
     * Constructor Vacío
     */
    public Banco() {
    }

    /**
     * Constructor con Parámetros
     * @param nombre
     * @param direccion
     * @param telefono
     */
    public Banco(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Getters y Setters Atributos Clase Banco
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getters y Setters de ArrayList Relacionadas de la Clase
     * @return
     */
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

    /**
     * To String Clase Banco
     * @return
     */
    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    /**
     * Método para Crear Usuario
     * @param nombre
     * @param direccion
     * @param cedula
     * @param correo
     * @param contrasena
     */
    public void crearUsuario(String nombre, String direccion, String cedula,
                             String correo, String contrasena) {
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

    /**
     * Método para Crear Cuenta
     * @param saldo
     */
    public void crearCuenta(int saldo) {
        Cuenta cuenta = new Cuenta();
        String cuentaUnico = generarNumeroCuentaUnico();
        cuenta.setNumeroCuenta(cuentaUnico);
        cuenta.setSaldo(saldo);
        getListaCuentas().add(cuenta);
    }

    /**
     * Método para Generar Número único para Cuenta de Ahorros
     * @return
     */
    private String generarNumeroCuentaUnico() {
        Cuenta cuenta = new Cuenta();
        String numeroCuenta;
        do {
            numeroCuenta = cuenta.generarNumeroCuenta();
        }while (verificarNumeroCuenta(numeroCuenta));
        return numeroCuenta;
    }

    /**
     * Método para Verificar el Número único para Cuenta de Ahorros
     * @param numeroCuenta
     * @return
     */
    private boolean verificarNumeroCuenta(String numeroCuenta) {
        boolean bandera = false;
        for (Cuenta cuenta: listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)){
                bandera = true;
            }
        }
        return bandera;
    }

    /**
     * Método para Devolver Posición de Usuario
     * @param cedula
     * @return
     */
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

    /**
     * Método para Eliminar Usuario
     * @param cedula
     */
    public void eliminarUsuario(String cedula) {
        for(Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                getListaUsuarios().remove(usuario);
                break;
            }
        }
    }

    /**
     * Método para Actualizar Información del Usuario
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param contrasena
     */
    public void actualizarUsuario(String cedula, String nombre, String direccion,
                                  String correo, String contrasena) {
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

    /**
     * Método para Determinar si Existe o no una Cuenta
     * @param numeroCuenta
     * @return
     */
    public boolean consultarCuenta(String numeroCuenta){
        boolean cuentaEncontrada = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCedula().equals(numeroCuenta)) {
                cuentaEncontrada = true;
                break;
            }
        }
        return cuentaEncontrada;
    }

    /**
     * Método para Revisar si el Saldo de la Cuenta es necesario para Realizar la Transacción
     * @param numeroCuenta
     * @param monto
     * @return
     */
    public boolean revisarSaldoNecesario(String numeroCuenta, float monto){
        boolean saldoNecesario = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getcedula().equals(numeroCuenta)) {
                double saldo = cuenta.getSaldo();
                if (saldo >= (monto + 200)){
                    saldoNecesario = true;
                    break;
                }
                break;
            }
        }
        return saldoNecesario;
    }

    /**
     * Método para Crear Transacciones
     * @param idCuentaOrigen
     * @param idCuentaDestino
     * @param valorTransferencia
     * @param categoriaGasto
     * @return
     */
    public boolean crearTransaccion(String cuentaOrigen, String cuentaDestino, float valor,
                                    Categoria categoria){
        boolean transaccionExitosa = false;

        Cuenta cuentaOrigen = obtenerCuenta(cuentaOrigen);
        Cuenta cuentaDestino = obtenerCuenta(cuentaDestino);

        if (consultarCuenta(cuentaDestino) && consultarCuenta(cuentaOrigen) &&
                revisarSaldoNecesario(cuentaDestino, valor)) {
            Transaccion transaccionCuentaOrigen = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.SALIDA);
            cuentaOrigen.getListaTransacciones().add(transaccionCuentaOrigen);
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-valorTransferencia-200);

            Transaccion transaccionCuentaLlegada = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.ENTRADA);
            cuentaDestino.getListaTransaciones().add(transaccionCuentaLlegada);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+valorTransferencia);

            trasaccionExitosa = true;
        }
        return trasaccionExitosa;
    }
}
package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Banco {

    /**
     * Atributos clase banco
     */
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * ArrayList relacionadas de la clase
     */
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Cuenta> listaCuentas = new ArrayList<>();

    /**
     * Constructor vacío
     */
    public Banco() {
    }

    /**
     * Constructor con parámetros
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
     * Getters y Setters atributos clase banco
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
     * Getters y Setters de ArrayList relacionadas de la clase
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
     * To String clase banco
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
     * Método para crear usuario
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
     * Método para crear cuenta
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
     * Método para generar número único para cuenta de ahorros
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
     * Método para verificar el número único para cuenta de ahorros
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
     * Método para devolver posición de usuario
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
     * Método para eliminar usuario
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
     * Método para actualizar información del usuario
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
     * Método para determinar si existe o no una cuenta de ahorros
     * @param numeroCuenta
     * @return
     */
    public boolean consultarCuenta(String idNumeroCuenta){
        boolean cuentaEncontrada = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(idNumeroCuenta)) {
                cuentaEncontrada = true;
                break;
            }
        }
        return cuentaEncontrada;
    }

    /**
     * Método para revisar si el saldo de la cuenta es necesario para realizar la transacción
     * @param numeroCuenta
     * @param monto
     * @return
     */
    public boolean revisarSaldoNecesario(String idNumeroCuenta, float monto){
        boolean saldoNecesario = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(idNumeroCuenta)) {
                float saldo = cuenta.getSaldo();
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
     * Método para retornar una cuenta de ahorros existente
     * @param numeroCuenta
     * @return
     */
    public Cuenta obtenerCuenta(String idNumeroCuenta) {
        Cuenta cuentaExistente = new Cuenta();
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(idNumeroCuenta)) {
                cuentaExistente = cuenta;
                break;
            }
        }
        return cuentaExistente;
    }

    /**
     * Método para buscar una cuenta en el ArrayList
     * @param idCuenta
     * @return
     */
    public boolean buscarCuenta(String idCuenta) {
        boolean cuentaExiste = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(idCuenta)) {
                cuentaExiste = true;
            }
        }
        return cuentaExiste;
    }

    /**
     * Método para crear transacciones
     * @param idCuentaOrigen
     * @param idCuentaDestino
     * @param valorTransferencia
     * @param categoriaGasto
     * @return
     */
    public boolean crearTransaccion(String idCuentaOrigen, String idCuentaDestino, float valor,
                                    Categoria categoria){
        boolean transaccionExitosa = false;

        Cuenta cuentaOrigen = obtenerCuenta(idCuentaOrigen);
        Cuenta cuentaDestino = obtenerCuenta(idCuentaDestino);

        if (buscarCuenta(idCuentaDestino) && buscarCuenta(idCuentaOrigen) &&
                revisarSaldoNecesario(idCuentaOrigen, valor)) {
            Transaccion transaccionCuentaOrigen = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.SALIDA);
            cuentaOrigen.getListaTransacciones().add(transaccionCuentaOrigen);
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-valorTransferencia-200);

            Transaccion transaccionCuentaLlegada = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.ENTRADA);
            cuentaDestino.getListaTransaciones().add(transaccionCuentaLlegada);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+valor);

            trasaccionExitosa = true;
        }
        return trasaccionExitosa;
    }

    /**
     * Método que detalla las transacciones realizadas 1 mes despues de una fecha ingresada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @return
     */
    public List<Transaccion> clasificarCuentasMes(String idCuentaAhorros, LocalDate fechaInicio){
        List<Transaccion> transaccionesMes = new ArrayList<Transaccion>();
        Cuenta cuenta = obtenerCuenta(idCuentaAhorros);
        for (Transaccion transaccion : cuenta.getListaTransaciones()) {
            for (LocalDate fecha = fechaInicio; fecha.isBefore(fechaInicio.plusDays(30)); fecha =
                    fecha.plusDays(1)){
                if(transaccion.getFecha().equals(fecha));
                transaccionesMes.add(transaccion);
            }
        }
        return transaccionesMes;
    }

    /**
     * Método para sumar las transacciones de 1 mes por el tipo de transacción realizada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param tipoTransaccion
     * @return
     */
    public double sumarMontoTipoTransaccion(String idCuentaAhorros, LocalDate fechaInicio,
                                            TipoTransaccion tipoTransaccion){
        float montosTipoMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(tipoTransaccion)){
                montosMes += transaccion.getValor();
            }
        } return montosTipoMes;
    }

    /**
     * PTE - Método para cálcular el porcentaje de gastos
     * @param valor1
     * @param valor2
     * @return
     */
    public double calcularPorcentaje(float monto1, float monto2){
        return ((monto1)/(monto1 + monto2))*100;
    }

    /**
     * Método para sumar las transacciones de 1 mes por la categoría de transacción realizada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param categoriaGasto
     * @return
     */
    public double sumarMontoCategoriaTransaccion(String idCuentaAhorros, LocalDate fechaInicio,
                                                 Categoria categoria){
        double montosCategoriaMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(TipoTransaccion.SALIDA)){
                if (transaccion.getCategoria().equals(categoria)) {
                    montosCategoriaMes += transaccion.getValor();
                }
            }
        } return montosCategoriaMes;
    }

    /**
     * Método para obtener los gastos e ingresos del mes por tipo y categoría de transacción
     * @param idCuentaAhorros
     * @param fechaInicio
     */
    public void obtenerGastosIngresosMes(String idCuentaAhorros, LocalDate fechaInicio){
        float ingresosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio,
                TipoTransaccion.ENTRADA);
        float gastosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio, TipoTransaccion.SALIDA);
        float porcentajesGastosMes = calcularPorcentaje(gastosMes, ingresosMes);
        float porcentajeIngresosMes = calcularPorcentaje(ingresosMes, gastosMes);
        float gastosFacturas = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                CategoriaGasto.FACTURAS);
        float gastosGasolina = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                CategoriaGasto.GASOLINA);
        float gastosRopa = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                CategoriaGasto.ROPA);
        float gastosViajes = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                CategoriaGasto.VIAJES);
    }
}
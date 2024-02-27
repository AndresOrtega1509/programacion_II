package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    public Usuario crearUsuario(String nombre, String direccion, String cedula, String correo, String contrasena) {

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

            return usuario;
        } else {
            System.out.println("El usuario ya esta creado en el sistema");
        }
        return  null;
    }

    public Cuenta crearCuenta(String cedula, int saldo) {

        Cuenta cuenta = new Cuenta();
        String cuentaUnico = generarNumeroCuentaUnico();
        cuenta.setNumeroCuenta(cuentaUnico);
        cuenta.setSaldo(saldo);

        Usuario usuario = obtenerUsuario(cedula);

        if (usuario != null){
            cuenta.setUsuarioAsociado(usuario);
        }
        getListaCuentas().add(cuenta);
        return cuenta;
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

            LocalDate fechaActual = LocalDate.now();
            Transaccion transaccionRemitente = new Transaccion(cuentaRemitente, cuentaDestinatario,monto, categoria, fechaActual, TipoTransaccion.SALIDA);
            cuentaRemitente.getListaTransacciones().add(transaccionRemitente);
            transferir(cuentaRemitente, monto);
            Transaccion transaccionDestinatario = new Transaccion(cuentaRemitente,cuentaDestinatario, monto, categoria, fechaActual, TipoTransaccion.ENTRADA);
            cuentaDestinatario.getListaTransacciones().add(transaccionDestinatario);
            depositar(cuentaDestinatario, monto);

        }
    }

    private void transferir(Cuenta cuentaRemitente, double monto) {

        double saldoRemitente = cuentaRemitente.getSaldo() - monto;

        costoTransferencia(cuentaRemitente, saldoRemitente);
    }

    private void costoTransferencia(Cuenta cuentaRemitente, double saldoRemitente) {

        double saldoFinalRemitente = saldoRemitente - 200;

        cuentaRemitente.setSaldo(saldoFinalRemitente);
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

    public double consultarSaldo(String cedula, String contrasena) {

        double saldoEncontrado = 0.0;

        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getUsuarioAsociado() != null && cuenta.getUsuarioAsociado().getCedula().equalsIgnoreCase(cedula) &&
                    cuenta.getUsuarioAsociado().getContrasena().equalsIgnoreCase(contrasena)) {

                saldoEncontrado = cuenta.getSaldo();

                if (cuenta.getListaTransacciones().isEmpty()){
                    System.out.println("El usuario no tiene registradas transacciones");
                }else {
                    obtenerTransacciom(cuenta);
                }
            }

        }

        System.out.println("\n" + "El saldo disponible en la cuenta es de: "+ saldoEncontrado +"\n");

        return saldoEncontrado;
    }

    private void obtenerTransacciom(Cuenta cuenta) {
        System.out.println("Lista de transacciones asociadas:");
        System.out.println(cuenta.getListaTransacciones());
    }

    public Usuario buscarUsuarioPorCedula(String cedula) {

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }

    public Transaccion consultarTransaccionFecha(LocalDate fechaConsulta) {

        Transaccion transaccionEncontrada = null;
        for (Cuenta cuenta : listaCuentas ){
            for (Transaccion transaccion : cuenta.getListaTransacciones()){
                if (transaccion.getFecha().equals(fechaConsulta)){
                    transaccionEncontrada = transaccion;
                }
            }
        }
        return transaccionEncontrada;
    }

    public void obtenerGastosIngresosMes(String idCuentaAhorros, LocalDate fechaInicio){
        float ingresosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio,
                TipoTransaccion.ENTRADA);
        float gastosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio, TipoTransaccion.SALIDA);
        float porcentajesGastosMes = calcularPorcentaje(gastosMes, ingresosMes);
        float porcentajeIngresosMes = calcularPorcentaje(ingresosMes, gastosMes);
        float gastosFacturas = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.FACTURA);
        float gastosGasolina = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.GASOLINA);
        float gastosRopa = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.ROPA);
        float gastosViajes = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.VIAJE);

        System.out.println("Los ingresos al mes son de: " + ingresosMes);
        System.out.println("Los gastos al mes son de: " + gastosMes);
        System.out.println("El porcentaje de gastos al mes es de: " + porcentajesGastosMes);
        System.out.println("El porcentaje de ingresos al mes es de: " + porcentajeIngresosMes);
        System.out.println("El gasto de facturas es de: " + gastosFacturas);
        System.out.println("El gasto de gasolina es de: " + gastosGasolina);
        System.out.println("El gasto de ropa es de: " + gastosRopa);
        System.out.println("El gasto de viajes es de: " + gastosViajes);
    }

    private float sumarMontoCategoriaTransaccion(String idCuentaAhorros, LocalDate fechaInicio, Categoria categoria) {
        double montosCategoriaMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(TipoTransaccion.SALIDA)){
                if (transaccion.getCategoria().equals(categoria)) {
                    montosCategoriaMes += transaccion.getValor();
                }
            }
        } return (float) montosCategoriaMes;
    }

    private float calcularPorcentaje(float monto1, float monto2) {

        return ((monto1)/(monto1 + monto2))*100;
    }

    private float sumarMontoTipoTransaccion(String idCuentaAhorros, LocalDate fechaInicio, TipoTransaccion tipoTransaccion) {
        float montosTipoMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(tipoTransaccion)){
                montosTipoMes += (float) transaccion.getValor();
            }
        } return montosTipoMes;
    }

    private List<Transaccion> clasificarCuentasMes(String idCuentaAhorros, LocalDate fechaInicio) {

        List<Transaccion> transaccionesMes = new ArrayList<>();
        Cuenta cuenta = obtenerCuenta(idCuentaAhorros);
        for (Transaccion transaccion : cuenta.getListaTransacciones()) {
            LocalDate fechaTransaccion = transaccion.getFecha();
            if (fechaTransaccion.getMonth() == fechaInicio.getMonth() && fechaTransaccion.getYear() == fechaInicio.getYear()) {
                transaccionesMes.add(transaccion);
            }
        }
        return transaccionesMes;
    }

    private Cuenta obtenerCuenta(String idCuentaAhorros) {
        Cuenta cuentaExistente = new Cuenta();
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(idCuentaAhorros)) {
                cuentaExistente = cuenta;
                break;
            }
        }
        return cuentaExistente;
    }
}

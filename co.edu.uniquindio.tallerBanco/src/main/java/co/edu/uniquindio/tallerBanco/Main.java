package co.edu.uniquindio.tallerBanco;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.model.Banco;
import co.edu.uniquindio.tallerBanco.model.Cuenta;
import co.edu.uniquindio.tallerBanco.model.Transaccion;
import co.edu.uniquindio.tallerBanco.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Banco banco = inicializarDatosPrueba();

        /*Crud Usuario*/

        /*Create*/
        crearUsuario("Carlos", "barrio Cecilia", "1094029384", "carlos@hotmail.com","1724", banco);
        crearUsuario("Sandra", "Conjunto Sinai", "1097564783", "sandra@hotmail.com","9083", banco);
        crearUsuario("Miguel", "Barrio la milagrosa", "1083849302", "miguel@hotmail.com","4039", banco);
        crearUsuario("Sara", "Barrio la castellana", "1032940394", "sara@hotmail.com","7645", banco);

        /*Read*/
        System.out.println("\n" + "-----> Información usuarios: " + "\n");
        mostrarInformacionUsuarios(banco);

        /*Delate*/
        eliminarUsuario("1094029384", banco);
        System.out.println("\n" + "-----> Informacion luego de eliminar: " + "\n" );
        mostrarInformacionUsuarios(banco);

        /*Update*/
        actualizarUsuario("1083849302", "Andres", "Barrio la adiela", "andres@gmail.com", "1234", banco);
        System.out.println("\n" + "-----> Informacion luego de actualizar: " + "\n");
        mostrarInformacionUsuarios(banco);

        /*Cuenta*/

        /*Create*/

        crearCuenta("1032940394",80000, banco);
        crearCuenta("1083849302",70000, banco);
        crearCuenta("1097564783",75000, banco);

        System.out.println("\n" + "Informacion Cuentas: " + "\n");
        mostrarInformacionCuentas(banco);

        /*Transferencia*/

        System.out.println("\n" + "-----> Informacion de transferencia:" + "\n");

        realizarTransferencia("524049384", "524049386", 30000,Categoria.ROPA,banco);
        mostrarInformacionTransferencias(banco);

        System.out.println("\n" + "-----> Informacion de cuentas luego de transferir:" + "\n");

        mostrarInformacionCuentas(banco);

        System.out.println("\n" + "-----> Consultar saldo de una cuenta:" + "\n");

        consultarSaldo("1083849302","1234", banco);

        LocalDate fechaConsulta = LocalDate.of(2024, 2, 26);

        System.out.println("-----> consulta de transaccion de acuerdo a la fecha: " + fechaConsulta);

        Transaccion consultaFechaTransaccion = banco.consultarTransaccionFecha(fechaConsulta);
        System.out.println(consultaFechaTransaccion);

        System.out.println("\n"+ "-----> Porcentaje de gastos e ingresos");
        banco.obtenerGastosIngresosMes("524049384", fechaConsulta );

    }

    private static void mostrarInformacionTransferencias(Banco banco) {
        for (Cuenta cuenta: banco.getListaCuentas()){
            cuenta.mostrarInformacionTransferencias();
        }
    }


    private static Banco inicializarDatosPrueba() {

        Banco banco = new Banco();
        banco.setNombre("Bancolombia");
        banco.setDireccion("Calle 20 Nro 12-21");
        banco.setTelefono("3203849302");

        return banco;
    }

    private static void crearUsuario(String nombre,
                                    String direccion,
                                    String cedula, String correo, String contrasena,
                                    Banco banco) {

        banco.crearUsuario(nombre, direccion, cedula, correo, contrasena);
    }

    private static void crearCuenta(String cedula, int saldo, Banco banco) {

        banco.crearCuenta(cedula, saldo);
    }

    private static void mostrarInformacionUsuarios(Banco banco) {

        List<Usuario> listaUsuarios = banco.obtenerUsuarios();
        int tamanoLista = listaUsuarios.size();
        for (int i=0; i < tamanoLista; i++) {
            Usuario usuario = listaUsuarios.get(i);
            System.out.println(usuario.obtenerInformacion());
        }

    }

    private static void mostrarInformacionCuentas(Banco banco) {

        List<Cuenta> listaCuentas = banco.obtenerCuentas();
        int tamanoLista = listaCuentas.size();
        for (int i=0; i < tamanoLista; i++) {
            Cuenta cuenta = listaCuentas.get(i);
            System.out.println(cuenta.obtenerInformacion());
        }
    }

    private static void eliminarUsuario(String cedula, Banco banco) {

        banco.eliminarUsuario(cedula);
    }

    private static void actualizarUsuario(String cedula, String nombre, String direccion, String correo, String contrasena, Banco banco) {

        banco.actualizarUsuario(cedula, nombre, direccion, correo, contrasena);
    }

    private static void realizarTransferencia(String numeroCuentaRemitente,String numeroCuentaDestinatario,double monto,Categoria categoria,Banco banco){

        banco.realizarTransferencia(numeroCuentaRemitente, numeroCuentaDestinatario, monto, categoria);
    }

    private static void consultarSaldo(String cedula, String contrasena, Banco banco) {

        banco.consultarSaldo(cedula, contrasena);
    }

}
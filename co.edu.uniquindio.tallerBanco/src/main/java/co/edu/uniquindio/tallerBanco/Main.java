package co.edu.uniquindio.tallerBanco;

import co.edu.uniquindio.tallerBanco.model.Banco;
import co.edu.uniquindio.tallerBanco.model.Cuenta;
import co.edu.uniquindio.tallerBanco.model.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Banco banco = inicializarDatosPrueba();

        /*Crud Usuario*/

        /*Create*/
        crearUsuario("Carlos", "barrio Cecilia", "1094029384", "carlos@hotmail.com","1724", banco);
        crearUsuario("Sandra", "Conjunto Sinai", "1097738093", "sandra@hotmail.com","9083", banco);
        crearUsuario("Miguel", "Barrio la milagrosa", "1083849302", "miguel@hotmail.com","4039", banco);

        /*Read*/
        System.out.println("Información usuarios: ");
        mostrarInformacionUsuarios(banco);

        /*Delate*/
        eliminarUsuario("1094029384", banco);
        System.out.println("-----> Informacion luego de eliminar: ");
        mostrarInformacionUsuarios(banco);

        /*Update*/
        actualizarUsuario("1083849302", "Andres", "Barrio la adiela", "andres@gmail.com", "1234", banco);
        System.out.println("-----> Informacion luego de actualizar: ");
        mostrarInformacionUsuarios(banco);

        /*Cuenta*/

        /*Create*/

        crearCuenta(10000, banco);
        crearCuenta(50000, banco);
        crearCuenta(20000, banco);

        System.out.println("Informacion Cuentas: ");
        mostrarInformacionCuentas(banco);
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

    private static void crearCuenta(int saldo, Banco banco) {

        banco.crearCuenta(saldo);
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
}
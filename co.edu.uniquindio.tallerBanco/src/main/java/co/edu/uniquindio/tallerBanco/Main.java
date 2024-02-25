package co.edu.uniquindio.tallerBanco;

import co.edu.uniquindio.tallerBanco.model.Banco;
import co.edu.uniquindio.tallerBanco.model.Cuenta;
import co.edu.uniquindio.tallerBanco.model.Usuario;

import java.util.List;

public class Main {

    /**
     * Main Principal del Proyecto
     * @param args
     */
    public static void main(String[] args) {

        //Declaración Método Inicializar Datos Prueba
        Banco banco = inicializarDatosPrueba();

        /*CRUD Usuario*/

        //Create
        crearUsuario("Carlos", "barrio Cecilia", "1094029384", "carlos@hotmail.com","1724", banco);
        crearUsuario("Sandra", "Conjunto Sinai", "1097738093", "sandra@hotmail.com","9083", banco);
        crearUsuario("Miguel", "Barrio la milagrosa", "1083849302", "miguel@hotmail.com","4039", banco);

        //Read
        System.out.println("Información usuarios: ");
        mostrarInformacionUsuarios(banco);

        //Update
        actualizarUsuario("1083849302", "Andres", "Barrio la adiela", "andres@gmail.com", "1234", banco);
        System.out.println("-----> Informacion luego de actualizar: ");
        mostrarInformacionUsuarios(banco);

        //Delate
        eliminarUsuario("1094029384", banco);
        System.out.println("-----> Informacion luego de eliminar: ");
        mostrarInformacionUsuarios(banco);

        /*CRUD Cuenta*/

        //Create
        crearCuenta(10000, banco);
        crearCuenta(50000, banco);
        crearCuenta(20000, banco);

        //Read
        System.out.println("Informacion Cuentas: ");
        mostrarInformacionCuentas(banco);
    }

    /**
     * Método para Inicializar Datos Prueba
     * @return
     */
    private static Banco inicializarDatosPrueba() {
        Banco banco = new Banco();
        banco.setNombre("Bancolombia");
        banco.setDireccion("Calle 20 Nro 12-21");
        banco.setTelefono("3203849302");
        return banco;
    }

    /**
     * Método para Crear Usuario
     * @param nombre
     * @param direccion
     * @param cedula
     * @param correo
     * @param contrasena
     * @param banco
     */
    private static void crearUsuario(String nombre,
                                    String direccion,
                                    String cedula, String correo, String contrasena,
                                    Banco banco) {
        banco.crearUsuario(nombre, direccion, cedula, correo, contrasena);
    }

    /**
     * Método para Crear Cuenta
     * @param saldo
     * @param banco
     */
    private static void crearCuenta(int saldo, Banco banco) {
        banco.crearCuenta(saldo);
    }

    /**
     * Método para Mostrar Información de Usuarios
     * @param banco
     */
    private static void mostrarInformacionUsuarios(Banco banco) {
        List<Usuario> listaUsuarios = banco.obtenerUsuarios();
        int tamanoLista = listaUsuarios.size();
        for (int i=0; i < tamanoLista; i++) {
            Usuario usuario = listaUsuarios.get(i);
            System.out.println(usuario.obtenerInformacion());
        }
    }

    /**
     * Método para Mostrar Informaciín de Cuentas
     * @param banco
     */
    private static void mostrarInformacionCuentas(Banco banco) {
        List<Cuenta> listaCuentas = banco.obtenerCuentas();
        int tamanoLista = listaCuentas.size();
        for (int i=0; i < tamanoLista; i++) {
            Cuenta cuenta = listaCuentas.get(i);
            System.out.println(cuenta.obtenerInformacion());
        }
    }

    /**
     * Método para Eliminar Usuario
     * @param cedula
     * @param banco
     */
    private static void eliminarUsuario(String cedula, Banco banco) {
        banco.eliminarUsuario(cedula);
    }

    /**
     * Método para Actualizar Usuario
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param contrasena
     * @param banco
     */
    private static void actualizarUsuario(String cedula, String nombre, String direccion, String correo,
                                          String contrasena, Banco banco) {
        banco.actualizarUsuario(cedula, nombre, direccion, correo, contrasena);
    }
}
package co.edu.uniquindio.tallerBanco.test;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;
import co.edu.uniquindio.tallerBanco.model.Banco;
import co.edu.uniquindio.tallerBanco.model.Cuenta;
import co.edu.uniquindio.tallerBanco.model.Transaccion;
import co.edu.uniquindio.tallerBanco.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class BancoTest {

    Banco banco;

    @BeforeEach
    public  void init(){
        banco = new Banco("Davivienda", "Calle 20", "3203849383");
    }

    @Test
    public void crearUsuarioTest(){

        banco.crearUsuario("Antonio", "Barrio el sinai", "1065839483", "antonio@gmail.com","567");
        List<Usuario> listaUsuarios = banco.obtenerUsuarios();
        Assertions.assertTrue(listaUsuarios != null);
    }

    @Test
    public void actualizarUsuarioTest(){
        Usuario usuario = banco.crearUsuario("Tomas", "Barrio galan", "1094960636", "tomas@gmail.com","092");
        banco.actualizarUsuario("1094960636", "Tomas", "Barrio la adiela", "tomas@hotmail.com", "092");
        String direccionActualizada = usuario.getDireccion();
        Assertions.assertEquals("Barrio la adiela", direccionActualizada);
    }

    @Test
    public void eliminarUsuarioTest(){
        banco.crearUsuario("Nicolas", "Barrio cecilia", "1024567384", "nicolas@gmail.com","453");
        banco.eliminarUsuario("1024567384");
        Usuario busquedaUsuario = banco.buscarUsuarioPorCedula("1024567384");
        Assertions.assertTrue(busquedaUsuario == null);
    }

    @Test
    public void CrearCuentaTest(){
        banco.crearUsuario("Sofia", "Barrio acacias", "1082849384", "sofia@gmail.com","123");
        Cuenta cuenta = banco.crearCuenta("1082849384", 40000);
        Assertions.assertTrue(cuenta != null);

    }

    @Test
    public void consultarSaldoTest(){
        banco.crearUsuario("Lucas", "Barrio sinai", "1016943313", "lucas@gmail.com","123");
        banco.crearUsuario("Daniela", "Barrio las colinas", "1094839293", "daniela@gmail.com","321");
        banco.crearCuenta("1016943313", 40000);
        banco.crearCuenta("1094839293", 30000);

        Assertions.assertEquals(40000,banco.consultarSaldo("1016943313","123"));

    }

    @Test
    public void realizarTransferencia(){

        banco.crearUsuario("Laura", "Barrio camellos", "1016943313", "laura@gmail.com","123");
        banco.crearUsuario("Sara", "Barrio la adiela", "1094839293", "sara@gmail.com","321");
        Cuenta cuenta = banco.crearCuenta("1016943313", 40000);
        Cuenta cuenta2 = banco.crearCuenta("1094839293", 30000);

        String numeroCuenta1 = cuenta.getNumeroCuenta();
        String numeroCuenta2 = cuenta2.getNumeroCuenta();

        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 10000, Categoria.GASOLINA);

        Assertions.assertEquals(40000, banco.consultarSaldo("1094839293", "321"));
    }

    @Test
    public void costoTransferenciaTest(){

        banco.crearUsuario("Luz", "Barrio adiela", "1016943313", "luz@gmail.com","476");
        banco.crearUsuario("Claudia", "Barrio castilla", "1094839293", "claudia@gmail.com","834");
        Cuenta cuenta = banco.crearCuenta("1016943313", 100000);
        Cuenta cuenta2 = banco.crearCuenta("1094839293", 50000);

        String numeroCuenta1 = cuenta.getNumeroCuenta();
        String numeroCuenta2 = cuenta2.getNumeroCuenta();

        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 30000, Categoria.ROPA);

        Assertions.assertEquals(69800, banco.consultarSaldo("1016943313", "476"));
    }

    @Test
    public void consultarTransaccionTest(){

        banco.crearUsuario("Laura", "Barrio camellos", "1016943313", "laura@gmail.com","123");
        banco.crearUsuario("Sara", "Barrio la adiela", "1094839293", "sara@gmail.com","321");
        Cuenta cuenta = banco.crearCuenta("1016943313", 40000);
        Cuenta cuenta2 = banco.crearCuenta("1094839293", 30000);

        String numeroCuenta1 = cuenta.getNumeroCuenta();
        String numeroCuenta2 = cuenta2.getNumeroCuenta();

        LocalDate fechaConsulta = LocalDate.of(2024, 2, 26);

        Transaccion transaccion = new Transaccion(cuenta, cuenta2, 30000, Categoria.VIAJE, fechaConsulta, TipoTransaccion.SALIDA);
        cuenta.getListaTransacciones().add(transaccion);

        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 30000, Categoria.VIAJE);
        Transaccion transaccionPorFecha = banco.consultarTransaccionFecha(fechaConsulta);

        Assertions.assertTrue(transaccionPorFecha != null);
    }

}

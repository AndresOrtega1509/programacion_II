package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.Main;
import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.model.Banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Cuenta {

    private String numeroCuenta;
    private double saldo;
    private Usuario usuarioAsociado;
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Banco ownedByBanco;

    /*Constructor*/

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo, Usuario usuarioAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuarioAsociado = usuarioAsociado;
    }

    /*Getters and Setters*/

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuario) {
        this.usuarioAsociado = usuario;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    public String generarNumeroCuenta() {

        int valorMinimo = 524049384;
        int valorMaximo = 524049386;
        Random random = new Random();

        int numeroAleatorio = valorMinimo + random.nextInt((valorMaximo - valorMinimo)+1);

        return String.valueOf(numeroAleatorio);

    }

    public String obtenerInformacion() {

        String informacion = "";
        informacion = informacion +
                "Numero cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n";

        Usuario usuarioAsociado = getUsuarioAsociado();
        if (usuarioAsociado != null){
            informacion += "Usuario asiciado: " + usuarioAsociado.obtenerInformacion() + "\n";
        }else {
            informacion += "Usuario asiciado: No disponible" + "\n";
        }

        return informacion;
    }

    public void mostrarInformacionTransferencias() {

        for (Transaccion transaccion: listaTransacciones){
            System.out.println(transaccion);
        }
    }

}

package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.Main;
import co.edu.uniquindio.tallerBanco.model.Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cuenta {

    private String numeroCuenta;
    private double saldo;
    private Usuario usuario;
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Banco ownedByBanco;

    /*Constructor*/

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo, Usuario usuario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        int valorMaximo = 584049384;
        Random random = new Random();

        int numeroAleatorio = valorMinimo + random.nextInt((valorMaximo - valorMinimo)+1);

        return String.valueOf(numeroAleatorio);

    }

    public String obtenerInformacion() {

        String informacion = "";
        informacion = informacion +
                "Numero cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n";

        return informacion;
    }
}

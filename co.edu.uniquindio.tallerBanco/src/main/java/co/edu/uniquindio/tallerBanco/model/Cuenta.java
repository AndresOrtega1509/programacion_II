package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.model.Banco;

public class Cuenta {

    private double numeroCuenta;
    private double saldo;
    Banco ownedByBanco;

    /*Constructor*/

    public Cuenta() {
    }

    public Cuenta(double numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    /*Getters and Setters*/

    public double getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(double numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    public double generarNumeroCuenta() {

        numeroCuenta = Math.random();

        return numeroCuenta;

    }

    public String obtenerInformacion() {

        String informacion = "";
        informacion = informacion +
                "Numero cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n";

        return informacion;
    }
}

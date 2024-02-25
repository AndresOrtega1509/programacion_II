package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.Main;
import co.edu.uniquindio.tallerBanco.model.Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cuenta {

    /**
     * Atributos Clase Cuenta
     */
    private String numeroCuenta;
    private double saldo;
    private Usuario usuario;

    /**
     * Variable para Relacionar Padre
     */
    Banco ownedByBanco;

    /**
     * Constructor Vacío
     */
    public Cuenta() {
    }

    /**
     * Constructor con Parámetros
     * @param numeroCuenta
     * @param saldo
     * @param usuario
     */
    public Cuenta(String numeroCuenta, double saldo, Usuario usuario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    /**
     * Getters y Setters Atributos Clase Cuenta
     * @return
     */
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

    /**
     *Getters y Setters de Variable para Relacionar Padre
     * @return
     */
    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    /**
     * To String Clase Transaccion
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }

    /**
     * Método para Generar el número de Cuenta de Ahorros de forms Aleatoria
     * @return
     */
    public String generarNumeroCuenta() {
        int valorMinimo = 524049384;
        int valorMaximo = 584049384;
        Random random = new Random();
        int numeroAleatorio = valorMinimo + random.nextInt((valorMaximo - valorMinimo)+1);
        return String.valueOf(numeroAleatorio);
    }

    /**
     * PTE PREGUNTAR ÁNDRES - Método para Obtener Información del Usuario
     * @return
     */
    public String obtenerInformacion() {
        String informacion = "";
        informacion = informacion +
                "Numero cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n";
        return informacion;
    }
}
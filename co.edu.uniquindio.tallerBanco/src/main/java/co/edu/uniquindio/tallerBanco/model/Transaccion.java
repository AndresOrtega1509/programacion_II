package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaccion {

    private String cuentaRemitente;
    private String cuentaDestinatario;
    private double valor;
    private Categoria categoria;
    private LocalDate fecha;
    private TipoTransaccion tipoTransaccion;
    private Banco ownedByBanco;

    /*Constructor*/

    public Transaccion() {
    }

    public Transaccion(Cuenta remitente, Cuenta destinatario, double valor, Categoria categoria, LocalDate fecha, TipoTransaccion tipoTransaccion) {
        this.cuentaRemitente = remitente.getNumeroCuenta();
        this.cuentaDestinatario = destinatario.getNumeroCuenta();
        this.valor = valor;
        this.categoria = categoria;
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;

    }


    /*Getters and Setters*/

    public String getCuentaRemitente() {
        return cuentaRemitente;
    }

    public void setCuentaRemitente(String cuentaRemitente) {
        this.cuentaRemitente = cuentaRemitente;
    }

    public String getCuentaDestinatario() {
        return cuentaDestinatario;
    }

    public void setCuentaDestinatario(String cuentaDestinatario) {
        this.cuentaDestinatario = cuentaDestinatario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaRemitente='" + cuentaRemitente + '\'' +
                ", cuentaDestinatario='" + cuentaDestinatario + '\'' +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", fecha=" + fecha +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }

}

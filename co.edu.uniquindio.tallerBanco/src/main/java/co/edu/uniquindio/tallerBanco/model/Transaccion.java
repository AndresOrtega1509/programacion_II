package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;
import co.edu.uniquindio.tallerBanco.enumeracion.TipoTransaccion;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaccion {

    /**
     * Atributos Clase Transaccion
     */
    private String remitente;
    private Cuenta cuentaOrigen;
    private String destinatario;
    private Cuenta cuentaDestino;
    private float valor;
    private date fecha;
    private Categoria categoria;
    private short costo;
    private TipoTransaccion tipoTransaccion;

    /**
     * Variable para Relacionar Padre
     */
    Banco ownedByBanco;

    /**
     * Constructor Vacío
     */
    public Transaccion() {
    }

    /**
     * Constructor con Parámetros
     * @param remitente
     * @param cuentaOrigen
     * @param destinatario
     * @param cuentaDestino
     * @param valor
     * @param fecha
     * @param categoria
     * @param costo
     * @param tipoTransaccion
     */
    public Transaccion(String remitente, Cuenta cuentaOrigen, String destinatario, Cuenta cuentaDestino,
                       float valor, date fecha, Categoria categoria, short costo, TipoTransaccion
                               tipoTransaccion) {
        this.remitente = remitente;
        this.cuentaOrigen = cuentaOrigen;
        this.destinatario = destinatario;
        this.cuentaDestino = cuentaDestino;
        this.valor = valor;
        this.fecha = new Date();
        this.categoria = categoria;
        this.costo = 200;
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Getters y Setters Atributos de Clase Transaccion
     * @return
     */
    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public date getFecha() {
        return fecha;
    }

    public void setFecha(date fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public short getCosto() {
        return costo;
    }

    public void setCosto(short costo) {
        this.costo = costo;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Getters y Setters de Variable para Relacionar Padre
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
        return "Transaccion{" +
                "remitente='" + remitente + '\'' +
                ", cuentaOrigen=" + cuentaOrigen +
                ", destinatario='" + destinatario + '\'' +
                ", cuentaDestino=" + cuentaDestino +
                ", valor='" + valor + '\'' +
                ", fecha=" + fecha +
                ", categoria=" + categoria +
                ", costo=" + costo +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
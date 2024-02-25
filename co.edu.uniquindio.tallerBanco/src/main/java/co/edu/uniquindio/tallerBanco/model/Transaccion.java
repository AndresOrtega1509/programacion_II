package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;

public class Transaccion {

    /**
     * Atributos Clase Transaccion
     */
    private String remitente;
    private String destinatario;
    private String valor;
    private Categoria categoria;

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
     * @param destinatario
     * @param valor
     * @param categoria
     */
    public Transaccion(String remitente, String destinatario, String valor, Categoria categoria) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.valor = valor;
        this.categoria = categoria;
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

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
                ", destinatario='" + destinatario + '\'' +
                ", valor='" + valor + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.enumeracion.Categoria;

public class Transaccion {

    private String remitente;
    private String destinatario;
    private String valor;
    private Categoria categoria;
    private Banco ownedByBanco;

    /*Constructor*/

    public Transaccion() {
    }

    public Transaccion(String remitente, String destinatario, String valor, Categoria categoria) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.valor = valor;
        this.categoria = categoria;
    }

    /*Getters and Setters*/

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String de) {
        this.remitente = de;
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

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }
}

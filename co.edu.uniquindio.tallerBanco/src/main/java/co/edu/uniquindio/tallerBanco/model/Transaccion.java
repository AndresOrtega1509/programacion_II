package co.edu.uniquindio.tallerBanco.model;

import co.edu.uniquindio.tallerBanco.model.Banco;

public class Transaccion {

    private String de;
    private String para;
    private String valor;
    Banco ownedByBanco;

    /*Constructor*/

    public Transaccion() {
    }

    public Transaccion(String de, String para, String valor) {
        this.de = de;
        this.para = para;
        this.valor = valor;
    }

    /*Getters and Setters*/

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }
}

package co.edu.uniquindio.patronBuilder.model;

import java.util.ArrayList;

public class Personaje {

    private String nombre;
    private int nivel;
    private String descripcion;
    private ArrayList<? extends Enum> habilidades;
    private ArrayList<? extends Enum> caracteristicas;

    public Personaje() {
    }

    public Personaje(String nombre, int nivel, String descripcion, ArrayList<? extends Enum> habilidades, ArrayList<? extends Enum> caracteristicas) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
        this.caracteristicas = caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<? extends Enum> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<? extends Enum> habilidades) {
        this.habilidades = habilidades;
    }

    public ArrayList<? extends Enum> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<? extends Enum> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", descripcion='" + descripcion + '\'' +
                ", habilidades=" + habilidades +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}

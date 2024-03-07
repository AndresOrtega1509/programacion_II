package co.edu.uniquindio.patronBuilder.model;

import co.edu.uniquindio.patronBuilder.model.enumeracion.CaracteristicasGuerrero;
import co.edu.uniquindio.patronBuilder.model.enumeracion.HabilidadesGuerrero;

import java.util.ArrayList;

public class GuerreroBuilder implements PersonajeBuilder {

    private final Personaje personaje = new Personaje();

    @Override
    public void asignarNombre(String nombre) {
        personaje.setNombre(nombre);
    }

    @Override
    public void asignarNivel(int nivel) {
        personaje.setNivel(nivel);
    }

    @Override
    public void asignarDescripcion(String descripcion) {
        personaje.setDescripcion(descripcion);
    }

    @Override
    public void asignarHabilidades(ArrayList<? extends Enum> habilidades) {
        ArrayList<HabilidadesGuerrero> habilidadesGuerreros = new ArrayList<>();

        habilidades.forEach(habilidad ->{
            if (!(habilidad instanceof HabilidadesGuerrero)){
                throw new RuntimeException("Habilidad no valida para un guerrero");
            }else{
                habilidadesGuerreros.add((HabilidadesGuerrero) habilidad);
            }
        });

        personaje.setHabilidades(habilidadesGuerreros);
    }

    @Override
    public void asignarCaracteristicas(ArrayList<? extends Enum> caracteristicas) {
        ArrayList<CaracteristicasGuerrero> caracteristicasGuerreros = new ArrayList<>();

        caracteristicas.forEach(caracteristica -> {
            if (!(caracteristica instanceof CaracteristicasGuerrero)){
                throw new RuntimeException("Caracteristica no valida para un mago");
            }else{
                caracteristicasGuerreros.add((CaracteristicasGuerrero) caracteristica );
            }
        });

        personaje.setCaracteristicas(caracteristicasGuerreros);
    }

    @Override
    public Personaje build() {
        return personaje;
    }
}

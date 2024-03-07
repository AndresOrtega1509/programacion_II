package co.edu.uniquindio.patronBuilder.model;

import java.util.ArrayList;

public class DirectorPersonaje {

    private final PersonajeBuilder builder;

    public DirectorPersonaje(PersonajeBuilder builder){
        this.builder = builder;
    }

    public void build(String nombre, int nivel, String descripcion, ArrayList<? extends Enum<?>> habilidades, ArrayList<? extends Enum<?>> caracteristicas){

        builder.asignarNombre(nombre);
        builder.asignarNivel(nivel);
        builder.asignarDescripcion(descripcion);
        builder.asignarHabilidades(habilidades);
        builder.asignarCaracteristicas(caracteristicas);

    }
}

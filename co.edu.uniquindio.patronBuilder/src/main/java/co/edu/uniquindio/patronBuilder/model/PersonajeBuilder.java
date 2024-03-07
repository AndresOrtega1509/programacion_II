package co.edu.uniquindio.patronBuilder.model;

import java.util.ArrayList;

public interface PersonajeBuilder {

    void asignarNombre(String nombre);
    void asignarNivel(int nivel);
    void asignarDescripcion(String descripcion);
    void asignarHabilidades(ArrayList<? extends Enum> habilidades);
    void asignarCaracteristicas(ArrayList<? extends Enum> caracteristicas);
    Personaje build();
}

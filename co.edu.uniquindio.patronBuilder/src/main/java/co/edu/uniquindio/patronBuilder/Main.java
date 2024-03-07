package co.edu.uniquindio.patronBuilder;

import co.edu.uniquindio.patronBuilder.model.DirectorPersonaje;
import co.edu.uniquindio.patronBuilder.model.GuerreroBuilder;
import co.edu.uniquindio.patronBuilder.model.Personaje;
import co.edu.uniquindio.patronBuilder.model.PersonajeBuilder;
import co.edu.uniquindio.patronBuilder.model.enumeracion.CaracteristicasGuerrero;
import co.edu.uniquindio.patronBuilder.model.enumeracion.HabilidadesGuerrero;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PersonajeBuilder builder = new GuerreroBuilder();
        DirectorPersonaje director = new DirectorPersonaje(builder);

        ArrayList<HabilidadesGuerrero> habilidades = new ArrayList<>();
        habilidades.add(HabilidadesGuerrero.ESCUDO_PROTECTOR);
        habilidades.add(HabilidadesGuerrero.ESPADA_AFILADA);

        ArrayList<CaracteristicasGuerrero> caracteristicas = new ArrayList<>();
        caracteristicas.add(CaracteristicasGuerrero.VITALIDAD);
        caracteristicas.add(CaracteristicasGuerrero.FUERZA);

        director.build("Andru", 3, "Nuevo personaje", habilidades, caracteristicas);

        Personaje guerrero = builder.build();

        System.out.println(guerrero);
    }
}
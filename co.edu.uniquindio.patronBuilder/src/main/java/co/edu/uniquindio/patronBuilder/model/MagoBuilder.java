package co.edu.uniquindio.patronBuilder.model;

import co.edu.uniquindio.patronBuilder.model.enumeracion.CaracteristicasMago;
import co.edu.uniquindio.patronBuilder.model.enumeracion.HabilidadesMago;

import java.util.ArrayList;

public class MagoBuilder implements PersonajeBuilder{

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
        ArrayList<HabilidadesMago> habilidadesMagos = new ArrayList<>();

        habilidades.forEach(habilidad -> {
            if (!(habilidad instanceof HabilidadesMago)){
                throw new RuntimeException("Habilidad no valida para un mago");

            }else {
                habilidadesMagos.add((HabilidadesMago) habilidad);
            }
        });

        personaje.setHabilidades(habilidadesMagos);
    }

    @Override
    public void asignarCaracteristicas(ArrayList<? extends Enum> caracteristicas) {
        ArrayList<CaracteristicasMago> caracteristicasMagos= new ArrayList<>();

        caracteristicas.forEach(caracteristica -> {
            if (!(caracteristica instanceof CaracteristicasMago)){
                throw new RuntimeException("Caracteristica no valida para un mago");
            }else {
                caracteristicasMagos.add((CaracteristicasMago) caracteristica);
            }
        });
        personaje.setCaracteristicas(caracteristicasMagos);
    }

    @Override
    public Personaje build() {
        return personaje;
    }
}

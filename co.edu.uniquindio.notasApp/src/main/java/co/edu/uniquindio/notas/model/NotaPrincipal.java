package co.edu.uniquindio.notas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class NotaPrincipal {

    private ArrayList<Nota> notas = new ArrayList<>();

    public void agregarNota(String titulo, String descripcion, String categoria){}
    public ArrayList<Nota> listarNotas(){
        return notas;
    }

}

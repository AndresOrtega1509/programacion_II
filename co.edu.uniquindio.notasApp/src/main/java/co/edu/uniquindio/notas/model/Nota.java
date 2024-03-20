package co.edu.uniquindio.notas.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nota {

    private String titulo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String categoria;
    private LocalDate fechaRecordatorio;
}

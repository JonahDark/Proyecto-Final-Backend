package com.jonatan.foodEvents.requests;


import com.jonatan.foodEvents.entities.Horario;
import com.jonatan.foodEvents.entities.TipoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;


/*
 *Lombok Anotación de datos @Data Genera getters para todos los campos,
 * un método toString útil e implementaciones hashCode y equals que verifican
 * todos los campos no transitorios.
 * También generará setters para todos los campos no finales, así como un constructor.
 * Anotaciones @Data Equivalente a la combinación de @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 */
@Data
public class CrearEventoRequest
{
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    private String nombre;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Horario horario;

    private Long id_decoracion;
    private Long id_ubicacion;
    private Long id_menu;
    private Double precio_total;
    private Boolean pago_confirmado;
    private Long id_usuario;
}

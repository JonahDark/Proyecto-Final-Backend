package com.jonatan.foodEvents.requests;

import com.jonatan.foodEvents.entities.TipoMenuDecoracion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CrearDecoracionRequest {

    @Enumerated(EnumType.STRING)
    private TipoMenuDecoracion tipo;
    private String nombre;
    private Double precio;
    private String foto;
}

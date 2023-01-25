package com.jonatan.foodEvents.requests;

import com.jonatan.foodEvents.entities.TipoUbicacion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CrearUbicacionRequest {
    @Enumerated(EnumType.STRING)
    private TipoUbicacion tipo;

    private String nombre;
    private Integer aforo;
    private Double precio;
    private String descripcion;
    private String foto;
}

package com.jonatan.foodEvents.requests;


import com.jonatan.foodEvents.entities.TipoMesa;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CrearOEditarMesaRequest {
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoMesa tipoMesa;
    private Long id_evento;
}

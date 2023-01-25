package com.jonatan.foodEvents.requests;

import lombok.Data;

@Data
public class CrearOEditarComensalRequest {
    private String nombre;
    private String apellidos;
    private Boolean alergeno;
    private Boolean infantil;
    private Long id_mesa;
}

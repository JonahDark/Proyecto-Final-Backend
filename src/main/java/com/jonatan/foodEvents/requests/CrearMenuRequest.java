package com.jonatan.foodEvents.requests;

import com.jonatan.foodEvents.entities.TipoMenuDecoracion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CrearMenuRequest {
    @Enumerated(EnumType.STRING)
    private TipoMenuDecoracion tipo;

    private String nombre;
    private Double precio_menu;
    private String foto;
    private Double precio_menu_infantil;
    private Double precio_menu_alergeno;
    private Double precio_menu_alergeno_infantil;
}

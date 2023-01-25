package com.jonatan.foodEvents.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMenu tipo;
    private String nombre;
    private Double precio;
    private String foto;
    private Double precio_menu_infantil;
    private Double precio_menu_alergeno;
    private Double precio_menu_alergeno_infantil;


}

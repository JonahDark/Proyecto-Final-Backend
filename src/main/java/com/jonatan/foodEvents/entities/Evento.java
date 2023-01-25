package com.jonatan.foodEvents.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
//Lombok @NoArgsConstructor generará un constructor sin argumentos/predeterminado, por defecto el constructor generado será público.
@NoArgsConstructor
//Lombok @AllArgsConstructor genera un constructor con un parámetro para cada campo en su clase, por defecto el constructor generado será público.
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    private String nombre;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Horario horario;

    private Double precio_total;
    private Boolean pagado;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mesa_evento")
    private List<Mesa> mesas = new ArrayList<Mesa>();

    @ManyToOne
    @JoinColumn(name = "usuario", foreignKey = @ForeignKey(name = "fk_evento_usuario"))
    private User usuario;


    @OneToOne
    @JoinColumn(name = "ubicacion")
    private Ubicacion ubicacion;


    @OneToOne
    @JoinColumn(name = "menu")
    private Menu menu;


    @OneToOne
    @JoinColumn(name = "decoracion")
    private Decoracion decoracion;

}



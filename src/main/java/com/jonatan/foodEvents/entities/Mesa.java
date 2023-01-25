package com.jonatan.foodEvents.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMesa tipoMesa;

    private String nombre;
    private Integer num_max_comensales;


    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mesa")
    private List<Comensal> comensales = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "mesa_evento", foreignKey = @ForeignKey(name = "fk_mesa_evento"))
    private Evento mesa_evento;




}

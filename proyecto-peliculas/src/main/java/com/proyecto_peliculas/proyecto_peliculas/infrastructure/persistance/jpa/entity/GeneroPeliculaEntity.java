package com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GeneroPeliculaEntity {
    /**
     * Id del genero de peliculas
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idGenero;


    /**
     * Nombre de cada genero de peliculas
     */
    @Column(name = "Nombre_Genero")
    private String nombreGenero;
}

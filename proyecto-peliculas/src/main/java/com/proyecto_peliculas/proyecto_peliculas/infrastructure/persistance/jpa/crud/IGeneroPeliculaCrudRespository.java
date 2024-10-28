package com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.crud;


import com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.entity.GeneroPeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGeneroPeliculaCrudRespository extends JpaRepository<GeneroPeliculaEntity, Integer> {


    Optional<GeneroPeliculaEntity> findBynombreGenero(String nombreGenero);
}

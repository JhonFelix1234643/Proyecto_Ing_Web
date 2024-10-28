package com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.mapper;

import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.entity.GeneroPeliculaEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir Entities o Models de BrandCar
 */
@Mapper (componentModel = "spring")
public interface IGeneroPeliculaMapper {

    /**
     * Transforma un objeto de dominio a una Entidad
     * @param generoPelicula Objeto de dominio como fuente
     * @return Entity mappeado
     */
    GeneroPeliculaEntity toGeneroPeliculaEntity(GeneroPelicula generoPelicula);

    /**
     * Transforma una Entidad a un objeto de dominio
     * @param generoPeliculaEntity Entity como fuente
     * @return Dto mappeado
     */
    GeneroPelicula toGeneroPelicula(GeneroPeliculaEntity generoPeliculaEntity);

}

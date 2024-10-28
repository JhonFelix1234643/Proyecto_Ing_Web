package com.proyecto_peliculas.proyecto_peliculas.domain.usecase;

import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoRequest;
import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoResponse;
import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de servicio para el caso de uso de la entidad GeneroPelicula.
 * Define las operaciones principales que puede realizar el servicio sobre el modelo de dominio.
 */
public interface IGeneroPeliculaServicePort {

    /**
     * Obtiene un género de película por su ID.
     *
     * @param idGenero el ID del género de película.
     * @return un Optional que contiene el género de película si se encuentra.
     */
    Optional<GeneroPelicula> getById(Integer idGenero);

    /**
     * Obtiene todos los géneros de películas disponibles.
     *
     * @return una lista de géneros de películas.
     */
    List<GeneroPelicula> getAllGeneroPelicula();

    /**
     * Guarda un nuevo género de película.
     *
     * @param generoPeliculaDtoRequest DTO que contiene el nombre del género a crear.
     * @return un DTO con la respuesta de la operación (código de estado y mensaje).
     */
    GeneroPeliculaDtoResponse saveGenero(GeneroPeliculaDtoRequest peliculasDtoRequest);

    /**
     * Actualiza un género de película existente.
     *
     * @param generoPelicula el género de película a actualizar.
     * @return un DTO con la respuesta de la operación (código de estado y mensaje).
     */
    GeneroPeliculaDtoResponse update(GeneroPelicula generoPelicula);

    /**
     * Elimina un género de película por su ID.
     *
     * @param idGenero el ID del género de película a eliminar.
     */
    void deleteById(Integer idGenero);
}

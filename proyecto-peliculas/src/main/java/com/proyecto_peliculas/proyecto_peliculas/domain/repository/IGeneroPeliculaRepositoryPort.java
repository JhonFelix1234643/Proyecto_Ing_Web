package com.proyecto_peliculas.proyecto_peliculas.domain.repository;

import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;

import java.util.Optional;
import java.util.List;

/**
 * Puerto de repositorio para el acceso a datos de la entidad GeneroPelicula.
 * Define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) que deben implementarse
 * para manejar los géneros de películas.
 */
public interface IGeneroPeliculaRepositoryPort {

    /**
     * Obtiene un género de película por su ID.
     *
     * @param idGenero el ID del género de película.
     * @return un Optional que contiene el género de película si se encuentra.
     */
    Optional<GeneroPelicula> getById(Integer idGenero);

    /**
     * Obtiene un género de película por su nombre.
     *
     * @param nombreGeneroPelicula el nombre del género de película.
     * @return un Optional que contiene el género de película si se encuentra.
     */
    Optional<GeneroPelicula> getByNombreGeneroPelicula(String nombreGeneroPelicula);

    /**
     * Obtiene todos los géneros de películas.
     *
     * @return una lista con todos los géneros de películas disponibles.
     */
    List<GeneroPelicula> getAllGeneroPelicula();

    /**
     * Guarda un nuevo género de película en el repositorio.
     *
     * @param nombreGeneroPelicula el nombre del género de película a guardar.
     * @return el género de película guardado.
     */
    GeneroPelicula save(String nombreGeneroPelicula);

    /**
     * Actualiza un género de película existente en el repositorio.
     *
     * @param generoPelicula el objeto de género de película actualizado.
     * @return el género de película actualizado.
     */
    GeneroPelicula update(GeneroPelicula generoPelicula);

    /**
     * Elimina un género de película por su ID.
     *
     * @param idGenero el ID del género de película a eliminar.
     */
    void deleteById(Integer idGenero);
}

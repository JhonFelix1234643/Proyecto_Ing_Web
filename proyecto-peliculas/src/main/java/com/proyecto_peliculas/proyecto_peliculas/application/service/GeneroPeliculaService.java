package com.proyecto_peliculas.proyecto_peliculas.application.service;

import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoRequest;
import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoResponse;
import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;
import com.proyecto_peliculas.proyecto_peliculas.domain.repository.IGeneroPeliculaRepositoryPort;
import com.proyecto_peliculas.proyecto_peliculas.domain.usecase.IGeneroPeliculaServicePort;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.exception.GeneroPeliculaExistsException;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.exception.GeneroPeliculaNotExistException;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que implementa la lógica de negocio para la entidad GeneroPelicula.
 * Actúa como intermediario entre el repositorio y el controlador, manejando las operaciones
 * CRUD para los géneros de películas.
 */
@Service
@RequiredArgsConstructor  // Lombok genera un constructor con los campos finales (inyección de dependencias).
public class GeneroPeliculaService implements IGeneroPeliculaServicePort {

    // Inyección del puerto del repositorio para acceder a los datos de GeneroPelicula.
    private final IGeneroPeliculaRepositoryPort generoPeliculaRepository;

    /**
     * Obtiene un género de película por su ID.
     *
     * @param idGenero el ID del género de película.
     * @return un Optional que contiene el género de película si se encuentra.
     */
    @Override
    public Optional<GeneroPelicula> getById(Integer idGenero) {
        return generoPeliculaRepository.getById(idGenero);
    }

    /**
     * Obtiene todos los géneros de películas disponibles.
     *
     * @return una lista de géneros de películas.
     */
    @Override
    public List<GeneroPelicula> getAllGeneroPelicula() {
        return generoPeliculaRepository.getAllGeneroPelicula();
    }

    /**
     * Guarda un nuevo género de película si no existe ya en el sistema.
     *
     * @param generoPeliculaDtoRequest DTO que contiene los datos del género a guardar.
     * @return un DTO de respuesta con el código y mensaje de éxito o error.
     */
    @Override
    public GeneroPeliculaDtoResponse saveGenero(GeneroPeliculaDtoRequest generoPeliculaDtoRequest) {
        // Verifica si el género ya existe en el repositorio
        if (generoPeliculaRepository.getByNombreGeneroPelicula(generoPeliculaDtoRequest.getNombreGeneroPeliculas()).isPresent()) {
            throw new GeneroPeliculaExistsException();  // Lanza una excepción si el género ya existe
        }

        // Guarda el nuevo género en el repositorio
        GeneroPelicula generoPelicula1 = generoPeliculaRepository.save(generoPeliculaDtoRequest.getNombreGeneroPeliculas());

        // Imprime el género guardado en la consola (esto puede eliminarse en producción)
        System.out.println("El genero de Pelicula Ingresado es: " + generoPelicula1);

        // Crea la respuesta con un código y mensaje de éxito
        GeneroPeliculaDtoResponse generoPeliculaDtoResponse = new GeneroPeliculaDtoResponse();
        generoPeliculaDtoResponse.setCodeResponse(StatusCodeResponse.OK.getValueCode());
        generoPeliculaDtoResponse.setMessageResponse(StatusCodeResponse.OK.getMesageStatus());
        return generoPeliculaDtoResponse;
    }

    /**
     * Actualiza un género de película si existe.
     *
     * @param generoPelicula el género de película a actualizar.
     * @return un DTO de respuesta con el código y mensaje de éxito o error.
     */
    @Override
    public GeneroPeliculaDtoResponse update(GeneroPelicula generoPelicula) {
        // Verifica si el género existe por ID
        if (generoPeliculaRepository.getById(generoPelicula.getIdGenero()).isEmpty()) {
            throw new GeneroPeliculaNotExistException();  // Lanza una excepción si el género no existe
        }

        // Verifica si el nuevo nombre del género ya está en uso
        if (generoPeliculaRepository.getByNombreGeneroPelicula(generoPelicula.getNombreGeneroPelcula()).isPresent()) {
            throw new GeneroPeliculaExistsException();  // Lanza una excepción si el nuevo nombre ya existe
        }

        // Actualiza el género en el repositorio
        generoPeliculaRepository.update(generoPelicula);

        // Crea la respuesta con un código y mensaje de éxito
        GeneroPeliculaDtoResponse generoPeliculaDtoResponse = new GeneroPeliculaDtoResponse();
        generoPeliculaDtoResponse.setCodeResponse(StatusCodeResponse.OK.getValueCode());
        generoPeliculaDtoResponse.setMessageResponse(StatusCodeResponse.OK.getMesageStatus());
        return generoPeliculaDtoResponse;
    }

    /**
     * Elimina un género de película por su ID si existe.
     *
     * @param idGenero el ID del género de película a eliminar.
     */
    @Override
    public void deleteById(Integer idGenero) {
        // Verifica si el género existe antes de eliminar
        if (generoPeliculaRepository.getById(idGenero).isEmpty()) {
            throw new GeneroPeliculaNotExistException();  // Lanza una excepción si el género no existe
        }

        // Elimina el género del repositorio
        generoPeliculaRepository.deleteById(idGenero);
    }
}



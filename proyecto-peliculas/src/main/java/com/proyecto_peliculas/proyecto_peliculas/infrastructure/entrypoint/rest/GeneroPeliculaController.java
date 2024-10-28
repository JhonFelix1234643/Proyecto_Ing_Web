package com.proyecto_peliculas.proyecto_peliculas.infrastructure.entrypoint.rest;


import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoRequest;
import com.proyecto_peliculas.proyecto_peliculas.application.dto.GeneroPeliculaDtoResponse;
import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;
import com.proyecto_peliculas.proyecto_peliculas.domain.usecase.IGeneroPeliculaServicePort;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.util.StatusCodeResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar los recursos relacionados con los géneros de películas.
 * Provee endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre los géneros de películas.
 */
@RestController
@RequestMapping("Genero")
@RequiredArgsConstructor
public class GeneroPeliculaController {

    /**
     * Servicio para manejar la lógica de negocio relacionada con los géneros de películas.
     * Inyectado automáticamente por Spring debido a la anotación @RequiredArgsConstructor.
     */
    private final IGeneroPeliculaServicePort generoPeliculaService;

    /**
     * Endpoint para obtener un género de película por su ID.
     *
     * @param Id El identificador del género de película.
     * @return Un ResponseEntity que contiene el género de película si se encuentra, o un estado 404 si no.
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<GeneroPelicula> getById(@PathVariable Integer Id) {
        return ResponseEntity.of(generoPeliculaService.getById(Id));
    }

    /**
     * Endpoint para obtener una lista con todos los géneros de películas.
     *
     * @return Un ResponseEntity con la lista de todos los géneros de películas y un estado 200 (OK).
     */
    @GetMapping(path = "all")
    public ResponseEntity<List<GeneroPelicula>> getAll() {
        return ResponseEntity.ok(generoPeliculaService.getAllGeneroPelicula());
    }

    /**
     * Endpoint para crear un nuevo género de película.
     *
     * @param generoPeliculaDtoRequest El objeto DTO que contiene los datos del nuevo género de película.
     * @return Un ResponseEntity con el género creado y un estado 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<GeneroPeliculaDtoResponse> saveGeneroPeliculaDto(@RequestBody GeneroPeliculaDtoRequest generoPeliculaDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(generoPeliculaService.saveGenero(generoPeliculaDtoRequest));
    }

    /**
     * Endpoint para actualizar un género de película existente.
     *
     * @param generoPeliculaDtoRequest El objeto que contiene los datos actualizados del género de película.
     * @return Un ResponseEntity con el género actualizado y un estado 200 (OK).
     */
    @PutMapping
    public ResponseEntity<GeneroPeliculaDtoResponse> updateGeneroGeneroDto(@RequestBody GeneroPelicula generoPeliculaDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(generoPeliculaService.update(generoPeliculaDtoRequest));
    }

    /**
     * Endpoint para eliminar un género de película por su ID.
     *
     * @param id El identificador del género de película que se desea eliminar.
     * @return Un ResponseEntity con estado 200 (OK) si la eliminación fue exitosa.
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteGeneroPeliculaDto(@PathVariable Integer id) {
        generoPeliculaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

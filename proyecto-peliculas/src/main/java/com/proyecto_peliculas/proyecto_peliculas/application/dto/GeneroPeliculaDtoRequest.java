package com.proyecto_peliculas.proyecto_peliculas.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Moldea un GeneroPeliculaDto para las peticiones.
 * Esta clase actúa como un Data Transfer Object (DTO) para recibir o enviar información
 * relacionada con los géneros de películas en las solicitudes.
 */
@Getter  // Genera automáticamente los getters para los campos.
@Setter  // Genera automáticamente los setters para los campos.
@NoArgsConstructor  // Crea un constructor vacío.
@AllArgsConstructor // Crea un constructor que acepta todos los campos como parámetros.
public class GeneroPeliculaDtoRequest {

    /**
     * Nombre de cada género de película insertado.
     * Representa el nombre del género de la película que se recibirá o enviará en las peticiones.
     */
    private String nombreGeneroPeliculas;
}

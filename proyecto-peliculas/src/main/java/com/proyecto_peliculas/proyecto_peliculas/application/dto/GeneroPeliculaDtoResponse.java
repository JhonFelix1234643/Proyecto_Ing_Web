package com.proyecto_peliculas.proyecto_peliculas.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase actúa como un Data Transfer Object (DTO) para enviar respuestas
 * relacionadas con los géneros de películas.
 * Contiene el mensaje y el código de respuesta de una operación.
 */
@Getter  // Genera automáticamente los getters para los campos.
@Setter  // Genera automáticamente los setters para los campos.
public class GeneroPeliculaDtoResponse {

    /**
     * Mensaje de respuesta que describe el resultado de la operación (éxito o error).
     */
    private String messageResponse;

    /**
     * Código de respuesta que representa el estado de la operación (por ejemplo, 200 para éxito, 400 para error).
     */
    private Integer codeResponse;
}

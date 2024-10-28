package com.proyecto_peliculas.proyecto_peliculas.infrastructure.exception;

public class GeneroPeliculaExistsException extends RuntimeException {
    public GeneroPeliculaExistsException(){
        super ("El nombre del genero de peliculas ya existe");
    }
}

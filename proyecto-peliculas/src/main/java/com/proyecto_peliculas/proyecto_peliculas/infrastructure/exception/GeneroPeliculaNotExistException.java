package com.proyecto_peliculas.proyecto_peliculas.infrastructure.exception;

public class GeneroPeliculaNotExistException extends RuntimeException {

    public GeneroPeliculaNotExistException(){
        super("El genero ingresado no existe en la base de datos");
    }
}

package com.proyecto_peliculas.proyecto_peliculas.infrastructure.util;

public enum StatusCodeResponse {
    OK(0, "exitoso"), ERROR_FUNCTIONAL(55, "Error de validacion"), ERROR_SERVER(99, "Error en el controlador");

    private final Integer valueCode;

    private final String mesageStatus;

    StatusCodeResponse(int value, String mesage){
        this.valueCode = value;
        this.mesageStatus = mesage;
    }

    public int getValueCode(){
        return valueCode;
    }

    public String getMesageStatus(){
        return mesageStatus;
    }
}

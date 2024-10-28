package com.proyecto_peliculas.proyecto_peliculas.domain.model;


/**
 * Moldeo un objeto de dominio de un GeneroPelicula.
 * Representa la entidad del género de una película dentro del dominio de la aplicación.
 */
public class GeneroPelicula {

    /**
     * Id del género de películas.
     * Identificador único de cada género.
     */
    private Integer idGenero;

    /**
     * Nombre del género de películas.
     */
    private String NombreGeneroPelicula;

    // Métodos getter y setter para acceder y modificar los campos privados.
    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGeneroPelcula() {
        return NombreGeneroPelicula;
    }

    public void setNombreGeneroPelicula(String NombreGeneroPeliculas) {
        this.NombreGeneroPelicula = NombreGeneroPeliculas;
    }

    /**
     * Constructor que inicializa el objeto GeneroPelicula con valores.
     *
     * @param idPeliculas            El ID del género de la película.
     * @param NombreGeneroPeliculas  El nombre del género de la película.
     */
    public GeneroPelicula(Integer idPeliculas, String NombreGeneroPeliculas) {
        this.idGenero = idPeliculas;
        this.NombreGeneroPelicula = NombreGeneroPeliculas;
    }

    /**
     * Constructor vacío para inicialización sin parámetros.
     * Útil para frameworks que requieren un constructor por defecto.
     */
    public GeneroPelicula() {
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación de cadena
     * del objeto GeneroPelicula.
     *
     * @return una cadena que contiene el id y el nombre del género.
     */
    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", NombreGeneroPelicula='" + NombreGeneroPelicula + '\'' +
                '}';
    }
}

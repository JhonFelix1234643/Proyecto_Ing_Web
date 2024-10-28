package com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.repository;

import com.proyecto_peliculas.proyecto_peliculas.domain.model.GeneroPelicula;
import com.proyecto_peliculas.proyecto_peliculas.domain.repository.IGeneroPeliculaRepositoryPort;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.crud.IGeneroPeliculaCrudRespository;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.entity.GeneroPeliculaEntity;
import com.proyecto_peliculas.proyecto_peliculas.infrastructure.persistance.jpa.mapper.IGeneroPeliculaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GeneroPeliculaRepository implements IGeneroPeliculaRepositoryPort {

    private final IGeneroPeliculaCrudRespository iGeneroPeliculaCrudRespository;
    private final IGeneroPeliculaMapper iGeneroPeliculaMapper;

    @Override
    public Optional<GeneroPelicula> getById(Integer idGenero){
        return iGeneroPeliculaCrudRespository
                .findById(idGenero)
                .map(iGeneroPeliculaMapper::toGeneroPelicula);
    }

    @Override
    public Optional<GeneroPelicula> getByNombreGeneroPelicula(String nombreGeneroPelicula){
        return iGeneroPeliculaCrudRespository
                .findBynombreGenero(nombreGeneroPelicula)
                .map(iGeneroPeliculaMapper::toGeneroPelicula);
    }

    @Override
    public List<GeneroPelicula> getAllGeneroPelicula(){
        return iGeneroPeliculaCrudRespository.findAll().stream().map(actual -> {
            GeneroPelicula generoPelicula = iGeneroPeliculaMapper.toGeneroPelicula(actual);
            return generoPelicula;
        }).toList();
    }

    @Override
    public GeneroPelicula save(String nombreGenero){
        GeneroPeliculaEntity generoPeliculaEntity = new GeneroPeliculaEntity();
        generoPeliculaEntity.setNombreGenero(nombreGenero);
        return iGeneroPeliculaMapper.toGeneroPelicula(iGeneroPeliculaCrudRespository.save(generoPeliculaEntity));
    }

    @Override
    public GeneroPelicula update(GeneroPelicula generoPelicula){
        return iGeneroPeliculaMapper
                .toGeneroPelicula(iGeneroPeliculaCrudRespository.save(iGeneroPeliculaMapper.toGeneroPeliculaEntity(generoPelicula)));
    }

    @Override
    public void deleteById(Integer idGenero){
        iGeneroPeliculaCrudRespository.deleteById(idGenero);
    }




}

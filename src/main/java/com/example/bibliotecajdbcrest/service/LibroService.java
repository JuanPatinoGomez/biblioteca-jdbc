package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.repository.LibrosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibrosRepository repoLibro;


    public List<Libro> listAllByTitle(String titulo){

        return this.repoLibro.listAllByTitle(titulo);
    }

    public List<Libro> listAllByGenero(int idGenero){
        return this.repoLibro.listAllByGenero(idGenero);
    }



    
}

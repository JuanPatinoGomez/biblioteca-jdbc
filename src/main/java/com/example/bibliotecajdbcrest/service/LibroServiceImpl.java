package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.model.LibroForm;
import com.example.bibliotecajdbcrest.repository.LibroRepoI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroServiceI{

    @Autowired
    private LibroRepoI repoLibro;


    public List<Libro> listAllByTitle(String titulo){

        return this.repoLibro.listAllByTitle(titulo);
    }

    public List<Libro> listAllByGenero(int idGenero){
        return this.repoLibro.listAllByGenero(idGenero);
    }

    @Override
    public List<Libro> listAll() {
        
        return this.repoLibro.listAll();
    }

    @Override
    public Libro listById(int id) {
        
        return this.repoLibro.listById(id);
    }

    @Override
    public boolean save(LibroForm object) {
        
        return this.repoLibro.save(object);
    }

    @Override
    public boolean update(LibroForm object, int id) {
        
        return this.repoLibro.update(object, id);
    }

    @Override
    public boolean delete(int id) {
        
        return this.repoLibro.delete(id);
    }

    @Override
    public List<Libro> listAllByIdAutor(int id) {
        
        return this.repoLibro.listAllByIdAutor(id);
    }



    
}

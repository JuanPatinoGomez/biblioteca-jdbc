package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Libro;

public interface LibroServiceI {
    
    List<Libro> listAll();
    Libro listById(int id);
    boolean save(Libro object);
    boolean update(Libro object, int id);
    boolean delete(int id);

    public List<Libro> listAllByIdAutor(int id);
    public List<Libro> listAllByTitle(String titulo);
    public List<Libro> listAllByGenero(int idGenero);

}

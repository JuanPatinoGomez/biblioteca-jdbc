package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.model.LibroForm;

public interface LibroRepoI {
    
    List<Libro> listAll();
    Libro listById(int id);
    boolean save(LibroForm object);
    boolean update(LibroForm object, int id);
    boolean delete(int id);

    public List<Libro> listAllByIdAutor(int id);
    public List<Libro> listAllByTitle(String titulo);
    public List<Libro> listAllByGenero(int idGenero);
}

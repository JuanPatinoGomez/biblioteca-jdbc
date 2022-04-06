package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;

public interface AutorServiceI {
    
    List<Autor> listAll();
    Autor listById(int id);
    boolean save(Autor object);
    boolean update(Autor object, int id);
    boolean delete(int id);
    List<Autor> listAllByName(String name);

}

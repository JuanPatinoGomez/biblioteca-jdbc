package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Genero;

public interface GeneroRepoI {
    
    public List<Genero> listAll();
    public Genero listById(int id);
}

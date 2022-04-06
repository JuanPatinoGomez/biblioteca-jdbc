package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Genero;

public interface GeneroServiceI {
    public List<Genero> listAll();
    public Genero listById(int id);
}

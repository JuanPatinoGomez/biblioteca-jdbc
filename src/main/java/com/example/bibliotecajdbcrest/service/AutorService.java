package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.repository.AutorRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    
    @Autowired
    private AutorRepositoryImpl autorRepositoryImpl;


    public List<Autor> listAllByName(String name){
        return this.autorRepositoryImpl.listAllByName(name);
    }
}

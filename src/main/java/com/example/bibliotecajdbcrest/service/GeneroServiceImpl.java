package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Genero;
import com.example.bibliotecajdbcrest.repository.GeneroRepoI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroServiceI{

    @Autowired
    GeneroRepoI generoRepo;

    @Override
    public List<Genero> listAll() {
        
        return this.generoRepo.listAll();
    }

    @Override
    public Genero listById(int id) {
        
        return this.generoRepo.listById(id);
    }
    
}

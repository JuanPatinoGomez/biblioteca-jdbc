package com.example.bibliotecajdbcrest.service;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.repository.AutorRepoI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorServiceI {
    
    @Autowired
    private AutorRepoI autorRepo;

    @Override
    public List<Autor> listAll() {
        return this.autorRepo.listAll();
    }


    @Override
    public Autor listById(int id) {
        
        return this.autorRepo.listById(id);
    }


    @Override
    public boolean save(Autor object) {
        
        return this.autorRepo.save(object);
    }


    @Override
    public boolean update(Autor object, int id) {
        
        return this.autorRepo.update(object, id);
    }


    @Override
    public boolean delete(int id) {
        
        return this.autorRepo.delete(id);
    }

    public List<Autor> listAllByName(String name){
        return this.autorRepo.listAllByName(name);
    }
}

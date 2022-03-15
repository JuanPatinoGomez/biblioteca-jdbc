package com.example.bibliotecajdbcrest.repository;

import java.util.List;

public interface RepoGeneral<T> {

    List<T> listAll();
    T listById(int id);
    boolean save(T object);
    boolean update(T object, int id);
    boolean delete(int id);
    
}

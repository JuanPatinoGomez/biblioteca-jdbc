package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("repogenero")
public class GeneroRepositoryImpl implements RepoGeneral<Genero>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Genero> rowMapper = (rs, row) -> {
        Genero genero = new Genero();
        genero.setIdGenero(rs.getInt("id"));
        genero.setGenero(rs.getString("genero"));
        return genero;
    };


    @Override
    public List<Genero> listAll() {

        String sql = "SELECT * FROM genero";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Genero listById(int id) {
        String sql = "SELECT * FROM genero WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public boolean save(Genero object) {
        
        return false;
    }

    @Override
    public boolean update(Genero object, int id) {
        
        return false;
    }

    @Override
    public boolean delete(int id) {
        
        return false;
    }

    
}

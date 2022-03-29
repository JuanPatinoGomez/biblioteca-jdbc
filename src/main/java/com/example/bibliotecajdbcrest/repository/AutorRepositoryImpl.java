package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("repoautor")
public class AutorRepositoryImpl implements AutorRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Autor> rowMapper = (rs, row) ->{

        Autor autor = new Autor();
        autor.setIdAutor(rs.getInt("id"));
        autor.setNombre(rs.getString("nombre"));

        return autor;
    };

    @Override
    public List<Autor> listAll() {
        
        String sql = "SELECT * FROM autor";

        return this.jdbcTemplate.query(sql, this.rowMapper);
    }

    @Override
    public Autor listById(int id) {
        
        String sql = "SELECT * FROM autor WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public boolean save(Autor object) {
        
        String sql = "INSERT INTO autor(nombre) values(?)";
        
        int result = this.jdbcTemplate.update(sql, object.getNombre());

        return result==1? true : false;
    }

    @Override
    public boolean update(Autor object, int id) {
        
        return false;
    }

    @Override
    public boolean delete(int id) {
        
        return false;
    }

    //Metodos consultas por buscador
    public List<Autor> listAllByName(String name){
        String sql = "SELECT * FROM autor WHERE nombre like '%" + name + "%'";
        return this.jdbcTemplate.query(sql, rowMapper);
    }
    
}

package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.model.Libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("repolibro")
public class LibrosRepository implements RepoGeneral<Libro>{

    @Autowired
    @Qualifier("repoautor")
    RepoGeneral<Autor> repoAutor;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Libro> rowMapper = (rs, row) ->{
        Libro libro = new Libro();
        libro.setId(rs.getInt("id"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setIdAutor(rs.getInt("idautor"));
        libro.setAnhoEdicion(rs.getInt("anhoedicion"));
        libro.setISBN(rs.getString("ISBN"));
        libro.setNumeroPaginas(rs.getInt("numeropaginas"));
        libro.setLinkImagen(rs.getString("linkimagen"));
        libro.setDescripcion(rs.getString("descripcion"));

        libro.setAutor(this.repoAutor.listById(rs.getInt("idautor"))); //Hacemos otra consulta para poder recibir el autor del libro

        return libro;
    };

    @Override
    public List<Libro> listAll() {

        String sql = "SELECT * FROM libro";
        return this.jdbcTemplate.query(sql, rowMapper);

    }

    @Override
    public Libro listById(int id) {
        
        String sql = "SELECT * FROM libro WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public boolean save(Libro object) {
        return false;
    }

    @Override
    public boolean update(Libro object, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        
        String sql = "DELETE FROM libro WHERE id = ? ";
        int resultado = this.jdbcTemplate.update(sql, id);
        return resultado > 0 ? true: false;  //Si el resultado es mayor a cero envia true, de lo contrario envia false
    }


    //Metodos fuera del crud
    public List<Libro> listAllByIdAutor(int id){

        String sql = "SELECT * FROM libro WHERE idautor = ?";
        return this.jdbcTemplate.query(sql, rowMapper, id);
    }

    //Metodos de consultar por buscador

    public List<Libro> listAllByTitle(String titulo){

        String sql = "SELECT * FROM libro WHERE titulo like '%" + titulo + "%'";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public List<Libro> listAllByGenero(int idGenero){

        String sql = "SELECT * FROM libro WHERE id IN (SELECT idlibro from libro_has_genero where idgenero = ?)";
        return this.jdbcTemplate.query(sql, rowMapper, idGenero);

    }
    
}

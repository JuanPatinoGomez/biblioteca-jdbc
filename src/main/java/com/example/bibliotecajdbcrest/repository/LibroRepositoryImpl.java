package com.example.bibliotecajdbcrest.repository;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.model.LibroForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("repolibro")
public class LibroRepositoryImpl implements LibroRepoI{

    @Autowired
    AutorRepoI repoAutor;

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

    private RowMapper<Integer> rowMapper2 = (rs, row) ->{
        return rs.getInt("id");
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
    public boolean save(LibroForm object) {

        String sql = "INSERT INTO libro(titulo, idautor, anhoedicion, ISBN, numeropaginas, linkimagen, descripcion) values(?,?,?,?,?,?,?)";
        
        //Se almacena el libro
        int resultado = this.jdbcTemplate.update(sql, object.getTitulo(), object.getIdAutor(), object.getAnhoEdicion(), object.getISBN(),
                                                object.getNumeroPaginas(), object.getLinkImagen(), object.getDescripcion());


        //Traemos el id del libro recien creado
        int idLibro = this.jdbcTemplate.queryForObject("SELECT MAX(id) AS id FROM libro", rowMapper2);
        System.out.println("el libro guardado tiene el id: " + idLibro);
        //se almacenar las relaciones de la tabla libro_has_genero
        
        object.getListadoGeneros().forEach(genero -> {

            String sqlre = "INSERT INTO libro_has_genero(idlibro, idgenero) values(?,?)";

            this.jdbcTemplate.update(sqlre, idLibro, genero);

        });


        return resultado > 0 ? true : false;
    }

    @Override
    public boolean update(LibroForm object, int id) {

        //Actualizamos el libro
        String sql = "update libro set titulo = ?, idautor = ?, anhoedicion = ?, ISBN = ?, numeropaginas = ?, linkimagen = ?, descripcion = ? "+
        " where id = ?";
        int resultado = this.jdbcTemplate.update(sql, object.getTitulo(), object.getIdAutor(), object.getAnhoEdicion(), object.getISBN(),
        object.getNumeroPaginas(), object.getLinkImagen(), object.getDescripcion(), id);

        //Eliminamos las relaciones de la tabla libro_has_genero

        this.jdbcTemplate.update("DELETE FROM libro_has_genero WHERE idlibro = ?", id);

        //Volvemos a almacenar las relaciones de la tabla libro_has_genero

        object.getListadoGeneros().forEach(genero -> {

            String sqlre = "INSERT INTO libro_has_genero(idlibro, idgenero) values(?,?)";

            this.jdbcTemplate.update(sqlre, id, genero);

        });

        return resultado > 0 ? true : false;
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

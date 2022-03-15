package com.example.bibliotecajdbcrest;

import java.util.List;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.model.Genero;
import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.repository.RepoGeneral;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaJdbcRestApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(BibliotecaJdbcRestApplication.class);

	@Autowired
	@Qualifier("repoautor")
	private RepoGeneral<Autor> repoAutor;

	@Autowired
	@Qualifier("repogenero")
	private RepoGeneral<Genero> repoGenero;

	@Autowired
	@Qualifier("repolibro")
	private RepoGeneral<Libro> repoLibro;
	
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaJdbcRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*log.info("Listado de autores ------------------------------------------");
		
		List<Autor> autores = this.repoAutor.listAll();

		autores.forEach(System.out::println);

		log.info("Listado de generos ------------------------------------------");
		
		List<Genero> generos = this.repoGenero.listAll();

		generos.forEach(System.out::println);

		log.info("Listado de libros ------------------------------------------");
		
		List<Libro> libros = this.repoLibro.listAll();

		libros.forEach(System.out::println);*/

		
		
		
	}

	//

}

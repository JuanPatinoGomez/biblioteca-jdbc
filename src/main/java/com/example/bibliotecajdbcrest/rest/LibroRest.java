package com.example.bibliotecajdbcrest.rest;

import java.util.List;
import java.util.Map;

import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restlibros")
public class LibroRest {

    @Autowired
    LibroService libroService;

    /*@GetMapping("/buscartitulo")
    public List<Libro> buscadorTitulo(@RequestBody String titulo){ //Este recibe texto plano

        System.out.println("El titulo recibido es: " + titulo);
        return this.libroService.listAllByTitle(titulo);

    }*/
    
    @PostMapping("/buscarportitulo")
    public List<Libro> buscadorTitulo(@RequestBody Map<String, String> mapa){ //Este recibe json

        System.out.println("El mapa recibido es: " + mapa);
        System.out.println("valor: " + mapa.get("buscador"));
        return this.libroService.listAllByTitle(mapa.get("buscador"));

    }


    @PostMapping("/buscarporgenero")
    public List<Libro> buscadorLibrosGenero(@RequestBody Map<String, Integer> mapa){
        return this.libroService.listAllByGenero(mapa.get("genero"));
    }
    
}

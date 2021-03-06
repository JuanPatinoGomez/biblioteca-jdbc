package com.example.bibliotecajdbcrest.controller;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.model.Genero;
import com.example.bibliotecajdbcrest.repository.LibrosRepository;
import com.example.bibliotecajdbcrest.repository.RepoGeneral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/", "/libreria"})
public class ControladorGeneral {

    @Autowired
    LibrosRepository repoLibros;

    /*@Autowired
    @Qualifier("repogenero")
    RepoGeneral<Genero> repoGenero;*/

    @Autowired
    @Qualifier("repoautor")
    RepoGeneral<Autor> repoAutor;
    

    @GetMapping("/librosautor/{id}")
    public ModelAndView librosAutores(@PathVariable(required = true, name = "id") int id){
        
        ModelAndView modelAndView = new ModelAndView("librosautor");
        modelAndView.addObject("libros", this.repoLibros.listAllByIdAutor(id));
        modelAndView.addObject("autor", this.repoAutor.listById(id));
        return modelAndView;
    }

    
}

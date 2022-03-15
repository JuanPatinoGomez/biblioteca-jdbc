package com.example.bibliotecajdbcrest.controller;

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
public class LibroController {
    
    @Autowired
    LibrosRepository repoLibros;

    @Autowired
    @Qualifier("repogenero")
    RepoGeneral<Genero> repoGenero;


    @GetMapping("/libros")
	public ModelAndView listadoLibros(){
        
        ModelAndView modelAndView = new ModelAndView("index");
        
        modelAndView.addObject("libros", this.repoLibros.listAll());
        modelAndView.addObject("generos", this.repoGenero.listAll());
        
        return modelAndView;
    }


    @GetMapping("/libro/{id}")
    public ModelAndView libro(@PathVariable(required = true, name = "id") int id){
        
        ModelAndView modelAndView = new ModelAndView("vista_libro");
        modelAndView.addObject("libro", this.repoLibros.listById(id));
        return modelAndView;
    }


}

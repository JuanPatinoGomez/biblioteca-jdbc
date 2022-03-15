package com.example.bibliotecajdbcrest.controller;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.repository.RepoGeneral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/", "/libreria"})
public class AutorController {
    

    @Autowired
    @Qualifier("repoautor")
    RepoGeneral<Autor> repoAutor;

    @GetMapping("/autores")
    public ModelAndView autores(){

        ModelAndView modelAndView = new ModelAndView("autores");
        modelAndView.addObject("autores", this.repoAutor.listAll());

        return modelAndView;

    }
}

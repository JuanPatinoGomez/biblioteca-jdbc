package com.example.bibliotecajdbcrest.controller;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.repository.RepoGeneral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/adminautores")
    public ModelAndView panelAdminAutores(){

        ModelAndView modelAndView = new ModelAndView("admin_autores_tabla");
        modelAndView.addObject("autores", this.repoAutor.listAll());

        return modelAndView;

    }

    @GetMapping("/autores/nuevo")
    public ModelAndView nuevoAutor(){

        ModelAndView modelAndView = new ModelAndView("form_nuevo_autor");
        modelAndView.addObject("autor", new Autor());

        return modelAndView;
    }

    @PostMapping("/autores/save")
    public String guardarAutor(@ModelAttribute Autor autor){

        System.out.println(autor.toString());
        this.repoAutor.save(autor);

        return "redirect:/adminautores";
    }

}

package com.example.bibliotecajdbcrest.controller;

import com.example.bibliotecajdbcrest.service.AutorServiceI;
import com.example.bibliotecajdbcrest.service.LibroServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/", "/libreria"})
public class ControladorGeneral {

    @Autowired
    LibroServiceI libroService;

    @Autowired
    AutorServiceI autorService;
    

    @GetMapping("/librosautor/{id}")
    public ModelAndView librosAutores(@PathVariable(required = true, name = "id") int id){
        
        ModelAndView modelAndView = new ModelAndView("librosautor");
        modelAndView.addObject("libros", this.libroService.listAllByIdAutor(id));
        modelAndView.addObject("autor", this.autorService.listById(id));
        return modelAndView;
    }

    
}

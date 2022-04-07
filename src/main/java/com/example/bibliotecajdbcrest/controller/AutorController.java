package com.example.bibliotecajdbcrest.controller;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.service.AutorServiceI;
import com.example.bibliotecajdbcrest.service.LibroServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/libreria"})
public class AutorController {
    
    @Autowired
    AutorServiceI autorService;

    @Autowired
    LibroServiceI libroService;

    @GetMapping("/autores")
    public ModelAndView autores(){

        ModelAndView modelAndView = new ModelAndView("autores");
        modelAndView.addObject("autores", this.autorService.listAll());

        return modelAndView;

    }

    @GetMapping("/autores/{id}/libros")
    public ModelAndView librosAutores(@PathVariable(required = true, name = "id") int id){
        
        ModelAndView modelAndView = new ModelAndView("librosautor");
        modelAndView.addObject("libros", this.libroService.listAllByIdAutor(id));
        modelAndView.addObject("autor", this.autorService.listById(id));
        return modelAndView;
    }

    /**Administracion */

    @GetMapping("/administracion/autores")
    public ModelAndView panelAdminAutores(){

        ModelAndView modelAndView = new ModelAndView("admin_autores_tabla");
        modelAndView.addObject("autores", this.autorService.listAll());

        return modelAndView;

    }

    @GetMapping("/administracion/autores/nuevo")
    public ModelAndView nuevoAutor(){

        ModelAndView modelAndView = new ModelAndView("form_nuevo_autor");
        modelAndView.addObject("autor", new Autor());

        return modelAndView;
    }

    @PostMapping("/administracion/autores/save")
    public String guardarAutor(@ModelAttribute Autor autor){

        System.out.println(autor.toString());
        this.autorService.save(autor);

        return "redirect:/libreria/administracion/autores";
    }

    @GetMapping("/administracion/autores/edit/{id}")
    public ModelAndView editarAutor(@PathVariable(required = true, name = "id")int id){

        ModelAndView modelAndView = new ModelAndView("form_nuevo_autor");
        modelAndView.addObject("autor", this.autorService.listById(id));

        return modelAndView;
    }

    @GetMapping("/administracion/autores/delete/{id}")
    public String eliminarAutor(@PathVariable(required = true, name = "id")int id){

        this.autorService.delete(id);

        return "redirect:/libreria/administracion/autores";
    }

    

    

}

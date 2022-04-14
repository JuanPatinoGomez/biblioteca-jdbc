package com.example.bibliotecajdbcrest.controller;


import com.example.bibliotecajdbcrest.model.Libro;
import com.example.bibliotecajdbcrest.model.LibroForm;
import com.example.bibliotecajdbcrest.service.AutorServiceI;
import com.example.bibliotecajdbcrest.service.GeneroServiceI;
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
@RequestMapping(path = {"/", "/libreria"})
public class LibroController {
    
    @Autowired
    LibroServiceI libroService;

    @Autowired
    GeneroServiceI generoService;

    @Autowired
    AutorServiceI autorService;


    @GetMapping(path = {"/" ,"/libros"})
	public ModelAndView listadoLibros(){
        
        ModelAndView modelAndView = new ModelAndView("index");
        
        modelAndView.addObject("libros", this.libroService.listAll());
        modelAndView.addObject("generos", this.generoService.listAll());
        
        return modelAndView;
    }


    @GetMapping("/libros/{id}")
    public ModelAndView libro(@PathVariable(required = true, name = "id") int id){
        
        ModelAndView modelAndView = new ModelAndView("vista_libro");
        modelAndView.addObject("libro", this.libroService.listById(id));
        return modelAndView;
    }


    /**Administracion */

    @GetMapping("/administracion/libros")
    public ModelAndView panelAdminAutores(){

        ModelAndView modelAndView = new ModelAndView("admin_libros_tabla");
        modelAndView.addObject("libros", this.libroService.listAll());

        return modelAndView;

    }

    
    @GetMapping("/administracion/libros/nuevo")
    public ModelAndView nuevoAutor(){

        ModelAndView modelAndView = new ModelAndView("form_nuevo_libro");
        modelAndView.addObject("libroform", new LibroForm());
        modelAndView.addObject("listaGeneros", generoService.listAll());
        modelAndView.addObject("listaAutores", autorService.listAll());

        return modelAndView;
    }

    @PostMapping("/administracion/libros/save")
    public String guardarAutor(@ModelAttribute LibroForm libroForm){

        System.out.println(libroForm.toString());
        //Si es igual a 0 se genera un nuevo autor, de lo contrario significa que se esta actualizando

        if(libroForm.getId() == 0){
            this.libroService.save(libroForm);
        }else{
            this.libroService.update(libroForm, libroForm.getId());
        }
        

        return "redirect:/libreria/administracion/libros";
    }

    @GetMapping("/administracion/libros/edit/{id}")
    public ModelAndView editarAutor(@PathVariable(required = true, name = "id")int id){

        Libro libro = this.libroService.listById(id);

        LibroForm libroForm = new LibroForm();
        libroForm.setId(id);
        libroForm.setTitulo(libro.getTitulo());
        libroForm.setAnhoEdicion(libro.getAnhoEdicion());
        libroForm.setISBN(libro.getISBN());
        libroForm.setNumeroPaginas(libro.getNumeroPaginas());
        libroForm.setLinkImagen(libro.getLinkImagen());
        libroForm.setDescripcion(libro.getDescripcion());


        ModelAndView modelAndView = new ModelAndView("form_nuevo_libro");
        modelAndView.addObject("libroform", libroForm);
        modelAndView.addObject("listaGeneros", generoService.listAll());
        modelAndView.addObject("listaAutores", autorService.listAll());

        return modelAndView;
    }

    @GetMapping("/administracion/libros/delete/{id}")
    public String eliminarAutor(@PathVariable(required = true, name = "id")int id){

        this.libroService.delete(id);

        return "redirect:/libreria/administracion/libros";
    }

}

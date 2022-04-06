package com.example.bibliotecajdbcrest.rest;

import java.util.List;
import java.util.Map;

import com.example.bibliotecajdbcrest.model.Autor;
import com.example.bibliotecajdbcrest.service.AutorServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restautores")
public class AutorRest {

    @Autowired
    private AutorServiceI autorService;

    @PostMapping("/buscarpornombre")
    public List<Autor> listAllByName(@RequestBody Map<String, String> mapa){
        return this.autorService.listAllByName(mapa.get("buscador"));
    }
    
}

package com.example.bibliotecajdbcrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/libreria"})
public class AdminController {
    

    @GetMapping("/administracion")
    public String panelDeAdministracion(){
        return "panel_administracion_libreria";
    }
}

package com.example.nuevaprueba;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller

public class controlador {
    @RequestMapping("")
    public String inicio(){

        return "inicio";
    }
}

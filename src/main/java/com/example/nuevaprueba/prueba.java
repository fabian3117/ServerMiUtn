package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class prueba {
@RequestMapping("")
    public String inicio(){

    return "inicio";
}
}

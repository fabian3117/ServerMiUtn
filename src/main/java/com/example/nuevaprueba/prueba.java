package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/")
public class prueba {
    
    @GetMapping("")
    @ResponseBody
    public String inicio(){

    return "inicio";
}
}

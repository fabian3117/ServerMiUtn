package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
@RequestMapping("")
public class prueba {
    
    @GetMapping("")
    public String inicio(){

    return "inicio";
}

     @GetMapping("/saludar")
    @ResponseBody
    public String teste(){

    return "SaludoTesteo";
}

    @PostMapping("")
@ResponseBody
    public String saludo(){
        return "saludo";
}
    
}

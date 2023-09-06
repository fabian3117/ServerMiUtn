package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/")
public class prueba {
    
    @GetMapping("")
    @ResponseBody
    public String inicio(){

    return "inicio";
}

    @PostMapping("")
@ResponseBody
    public String saludo(){
        return "saludo";
}
    
}

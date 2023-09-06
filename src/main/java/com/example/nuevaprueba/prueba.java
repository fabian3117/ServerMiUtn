package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
@RequestMapping("")
public class prueba {
     @Autowired
    private MateriasRepo materiasRepo;
    
    @GetMapping("")
    public String inicio(){

    return "inicio";
}

      @GetMapping("/saludar")
    @ResponseBody
    public String teste(){
        List<Materias> materiasList=materiasRepo.findAll();
        return (materiasList.isEmpty()?"vacio":"conALgo");
//        return "SaludoTesteo";
    }

    @PostMapping("")
@ResponseBody
    public String saludo(){
        return "saludo";
}
    
}

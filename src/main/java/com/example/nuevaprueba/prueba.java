package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
     @RequestMapping("/mostrar")
  //  @ResponseBody
    public String Saludo(Model model){
      //  System.out.println("SS");
        List<Materias> materias=materia.findAll();
//        model.addAttribute("elementos",materias.get(0).getNombreMateria());
        ArrayList<String> nombreMaterias = new ArrayList<>();
        materias.forEach(elemento ->{
        nombreMaterias.add(elemento.getNombreMateria());
        });

        model.addAttribute("elementos",nombreMaterias);
        model.addAttribute("materias",materias);
        return "principal";
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

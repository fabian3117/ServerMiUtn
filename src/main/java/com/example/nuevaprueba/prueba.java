package com.example.nuevaprueba;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;


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
     @GetMapping("/mostrar")
    //@ResponseBody
    public String Saludo(Model model){
      //  System.out.println("SS");
        List<Materias> materias=materiasRepo.findAll();
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
        return (materiasList.isEmpty()?"vacioTT":"conALgoss");
//        return "SaludoTesteo";
    }

    @PostMapping("")
@ResponseBody
    public String saludo(){
        return "saludo";
}
      @GetMapping("/lectura/{id}")
   // @ResponseBody
    public String Lectura(@PathVariable String id, Model model) throws IOException {
        //String resourceName="archivosMarkdown/info1.md";
  //      String resourceName="archivosMarkdown/"+id;
//        ClassPathResource resource = new ClassPathResource(resourceName);
          System.out.println("ESS");
        ClassPathResource resource = Archivos.ObtenerPathArchivo(CategoriaArchivos.archivosMarkdown,id);
        Parser parser = Parser.builder().build();
        model.addAttribute("Titulo",id);
        if(resource.exists()){
            System.out.println("EXISTE");
            String markdownContent= StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
            Node document = parser.parse(markdownContent);
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String htmlContent = renderer.render(document);
            model.addAttribute("htmlContent", htmlContent);
            return "testMarkdown";
        }
        else{
            System.out.println("No Existe");
            return "principal";
        }
    }

     
    
}

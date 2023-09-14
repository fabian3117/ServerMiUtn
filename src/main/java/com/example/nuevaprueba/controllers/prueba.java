package com.example.nuevaprueba.controllers;
import com.example.nuevaprueba.*;
import com.example.nuevaprueba.enums.CategoriaArchivos;
import com.example.nuevaprueba.utils.Generales;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.io.*;
import java.util.List;

import java.util.ArrayList;

@Controller
@Slf4j
//@RestController
@RequestMapping("")
public class prueba {
     @Autowired
    private MateriasRepo materiasRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    
    @GetMapping("/mostrar")
    public String inicio(){

    return "inicio";
}
@GetMapping("/inicializar")
public String inicializar(){


            //-->   No tenemos datos    <--
            ArrayList<String> strings= new ArrayList<>();
            strings.add("Álgebra y Geometría Analítica-11");
            strings.add("Análisis Matemático I-11");
            strings.add("Física I-11");
            strings.add("Informática I-11");
            strings.add("Ingeniería y Sociedad-11");
            strings.add("Química General-11");
            strings.add("Análisis Matemático II-21");
            strings.add("Física II-21");
            strings.add("Informática II-21");
            strings.add("Inglés I-21");
            strings.add("Diseño Asistido por Computadora-21");
            strings.add("Análisis de Señales y Sistemas-22");
            strings.add("Física Electrónica-22");
            strings.add("Probabilidad y Estadística-22");
            strings.add("Análisis de Señales y Sistemas-31");
            strings.add("Dispositivos Electrónicos-31");
            strings.add("Medios de Enlace-31");
            strings.add("Técnicas Digitales I-31");
            strings.add("Teoría de los Circuitos I-31");
            strings.add("Inglés II-31");
            strings.add("Electrónica Aplicada I-32");
            strings.add("Legislación-32");
            strings.add("Electrónica Aplicada II-41");
            strings.add("Máquinas e Instalaciones Eléctricas-41");
            strings.add("Medidas Electrónicas I-41");
            strings.add("Seguridad, Higiene y Medio Ambiente-41");
            strings.add("Sistemas de Comunicaciones-41");
            strings.add("Técnicas Digitales II-41");
            strings.add("Teoría de los Circuitos II-41");
            strings.add("Electrónica Aplicada III-51");
            strings.add("Electrónica de Potencia-51");
            strings.add("Medidas Electrónicas II-51");
            strings.add("Sistemas de Control-51");
            strings.add("Técnicas Digitales III-51");
            strings.add("Tecnología Electrónica-51");
            strings.add("Proyecto Final-61");
            strings.add("Economía-61");
            strings.add("Organización Industrial-61");
            strings.add("Materias Electivas-61");
            for (String string : strings) {
                Materias materias = new Materias();
                materias.setNombreMateria(string);
                materias.setAnio(Generales.anioDefault);
                materias.setCuatrimestre(Generales.cuatrimestreDefault);
                materiasRepo.save(materias);
            }
        return "redirect:/";
}
     @GetMapping("")
    //@ResponseBody
    public String Saludo(Model model){
        List<Materias> materias=materiasRepo.findAll();
        ArrayList<String> nombreMaterias = new ArrayList<>();
        materias.forEach(elemento ->{
        nombreMaterias.add(elemento.getNombreMateria());
        });
        log.info("Entramos INFO");
        log.error("Entramos ERROR");
        model.addAttribute("elementos",nombreMaterias);
        model.addAttribute("materias",materias);
       //  return "inicio";
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
          Resource resource = new ClassPathResource("archivosMarkdown/Info1.md");

          model.addAttribute("error",resource.exists()?"Existe":"NO Existe");
          String markdownContent= Archivos.StringFileAsociado(id, CategoriaArchivos.archivosMarkdown);
            model.addAttribute("Titulo",id);
          model.addAttribute("htmlContent", Archivos.MarkdownToHtml(markdownContent));
            return "testMarkdown";

    }
    @GetMapping("/verificacion/{id}")
    @ResponseBody
    public String Verificacion(@PathVariable String id, Model model){
return        Archivos.StringFileAsociado(id,CategoriaArchivos.archivosMarkdown);
    }
}

package com.example.nuevaprueba;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;


import java.io.*;
import java.util.List;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Controller
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
        /*
        if(!materiasRepo.existsByIdIsNotEmpty()){
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
        }*/
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

          model.addAttribute("error","resource.getPath()");
          String markdownContent=Archivos.StringFileAsociado(id,CategoriaArchivos.archivosMarkdown);
            model.addAttribute("Titulo",id);
          model.addAttribute("htmlContent", Archivos.MarkdownToHtml(markdownContent));
            return "testMarkdown";

    }
    @GetMapping("/verificacion/{id}")
    @ResponseBody
    public String Verificacion(@PathVariable String id, Model model){
       /* //-->   Vamos a verificar si podemos obtener acceso a un archivo    <--
        //String DIRECCION = "C://home/site/wwwroot/archivosMarkdown/info.md";
        String DIRECCION = "C:\\home\\site\\wwwroot\\archivosMarkdown\\info.md";
        ArrayList<String> buf = new ArrayList<>();
        try {
            // Abre el archivo para lectura
            FileInputStream archivoEntrada = new FileInputStream(DIRECCION);
            InputStreamReader lector = new InputStreamReader(archivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(lector);

            // Lee el contenido línea por línea
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                // Procesa cada línea como desees
                System.out.println(linea);
                buf.add(linea);
            }
            // Cierra los recursos
            bufferedReader.close();
            lector.close();
            archivoEntrada.close();
            return buf;
        } catch (IOException e) {
            e.printStackTrace();
            return buf;
        }*/
return        Archivos.StringFileAsociado(id,CategoriaArchivos.archivosMarkdown);
      //  return null;




    }
    /*
    @GetMapping("/correo/{id}")
    @ResponseBody
    public String tryMail(@PathVariable String id) throws MessagingException, javax.mail.MessagingException {
        System.out.println(id);
        String email="fabian3117@frba.utn.edu.ar";
        String message = "Welcome to Udeesa, test token";
        String from = "no-reply@udeesa.org";
        javax.mail.internet.MimeMessage mimeMessage1 = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage1,"utf-8");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("EMAIL_CONFIRMATION_SUBJECT");
        mimeMessageHelper.setText(email);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    //    helper.setText(email);
        return "";
    }*/
    
}

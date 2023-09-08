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

package com.example.nuevaprueba.controllers;

import com.example.nuevaprueba.Archivos;
import com.example.nuevaprueba.CorreoModelo;
import com.example.nuevaprueba.utils.Generales;
import com.example.nuevaprueba.enums.CategoriaArchivos;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;

/**
 * Este controlador se va a encargar de gestionar los envios de correo electronicos
 */

@RequestMapping("/Correos")
@Controller
//TODO Para evitar una saturacion analoga a ataque DDOS luego implementare seguridad con springboot security
public class ControlerMails {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private final SpringTemplateEngine springTemplateEngine;

    public ControlerMails(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public void EnvioCorreo(@PathVariable String id, @ModelAttribute CorreoModelo correoModelo) throws MessagingException, javax.mail.MessagingException, IOException {
        javax.mail.internet.MimeMessage mimeMessage1 = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage1,"utf-8");
        mimeMessageHelper.setFrom("Noresponder@gmail.com");
        mimeMessageHelper.setTo(correoModelo.getCorreo());

        mimeMessageHelper.setSubject( Generales.MensajeMailApuntes);
        String markdownContent= Archivos.StringFileAsociado(id, CategoriaArchivos.archivosMarkdown);
        Context context = new Context();
        context.setVariable("htmlContent",markdownContent);
        String content = springTemplateEngine.process("templateMails", context);


        mimeMessageHelper.setText(content,true);
        //mimeMessageHelper.addAttachment("Adjunto",Archivos.obtainFile(CategoriaArchivos.archivosPDF,"Info1.pdf"));
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }


}

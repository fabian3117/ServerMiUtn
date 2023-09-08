package com.example.nuevaprueba;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    @ResponseBody
    public void EnvioCorreo(@PathVariable String id, @ModelAttribute CorreoModelo correoModelo) throws MessagingException, javax.mail.MessagingException, IOException {
        javax.mail.internet.MimeMessage mimeMessage1 = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage1,"utf-8");
        mimeMessageHelper.setFrom("Noresponder@gmail.com");
        mimeMessageHelper.setTo(correoModelo.getCorreo());

        mimeMessageHelper.setSubject( Generales.MensajeMailApuntes);
        String markdownContent=Archivos.StringFileAsociado(id,CategoriaArchivos.archivosMarkdown);
        mimeMessageHelper.setText(markdownContent,true);
        //mimeMessageHelper.addAttachment("Adjunto",Archivos.obtainFile(CategoriaArchivos.archivosPDF,"Info1.pdf"));
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }


}

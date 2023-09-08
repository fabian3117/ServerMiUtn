package com.example.nuevaprueba;
/*
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * Este controlador se va a encargar de gestionar los envios de correo electronicos
 */
/*
@RequestMapping("/Correos")
@Controller
//TODO Para evitar una saturacion analoga a ataque DDOS luego implementare seguridad con springboot security
public class ControlerMails {

@Autowired
    private final MailSenderConfig javaMailSender;
    @Autowired
    private final SpringTemplateEngine springTemplateEngine;

    public ControlerMails(MailSenderConfig javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }


    /**
     * Metodo encargado del envio del correo con los datos adjuntos
     * @param id Identificador del archivo
     * @param correoModelo Datos para saber a quien enviar el correo
     * @throws MessagingException
     * @throws IOException
     * @throws MessagingException
     */
/*
*/
/*
    @GetMapping("/{id}")
    @ResponseBody
    public void EnvioCorreo(@PathVariable String id,@ModelAttribute CorreoModelo correoModelo)throws MessagingException, IOException, MessagingException{
/*
        //TODO Verificaciones de seguridad y optimizaciones de excepciones  <--
        System.out.println(id);
        System.out.println(correoModelo.getNombre());

        //-->   Verificacion de la existencia de ese archivo o retornar error   <--
        //-->   En caso de existir el archivo debere adjuntarlo <--
        Context context = new Context();
        String content = springTemplateEngine.process("templateMails", context);
       // jakarta.mail.internet.MimeMessage mimeMessage=javaMailSender.mailSender().createMimeMessage();
        MimeMessage Mensaje = javaMailSender.mailSender().createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(Mensaje, true);
        helper.setFrom("GBA_Resoluciones@outlook.com.ar");
        //-->   Debug   <--
        //helper.setTo(Generalidades.toMailsTest);
        //helper.setSubject(Generalidades.subjectMailsSendSummary);
        helper.setSubject("Hola "+correoModelo.getNombre()+" Tus resumenes");
        helper.setTo(correoModelo.getCorreo());
        helper.setText("text");
        helper.setText(content, true);
        //TODO TERMINAR ESTO
//        helper.addAttachment("Resumen",null);
        helper.addAttachment(Archivos.nameFilePDF(id), Archivos.obtainFile(CategoriaArchivos.archivosPDF,id));
        javaMailSender.mailSender().send(Mensaje);
//        javaMailSender.send(Mensaje);
    */
/*}
}
*/
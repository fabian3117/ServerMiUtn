package com.example.nuevaprueba.services;

import com.example.nuevaprueba.EmailConfig;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;

import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;


@Service
public class EnvioCorreos {
    @Autowired
    EmailConfig emailConfig;
    @Autowired
    TemplateEngine templateEngine;
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        emailConfig.getJavaMailSender().send(message);
    }
    public void sendHtmlEmail(String to, String subject, String templateName, Context context) throws MessagingException, javax.mail.MessagingException {
        MimeMessage message = emailConfig.getJavaMailSender().createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);

        // Procesar la plantilla Thymeleaf
        String htmlContent = templateEngine.process(templateName, (IContext) context);
        helper.setText(htmlContent, true);

        emailConfig.getJavaMailSender().send(message);
    }
}

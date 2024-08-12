package com.oracle.mailservice.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String from;


    public void sendReport(String content, String to){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject("Relátorio do mês - 13 de Agosto meu aniversário");
            helper.setTo(to);
            javaMailSender.send(message);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


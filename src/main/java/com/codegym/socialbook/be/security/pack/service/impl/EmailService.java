package com.codegym.socialbook.be.security.pack.service.impl;


import com.codegym.socialbook.be.security.pack.service.IEmailSender;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmailService implements IEmailSender {
    private final JavaMailSender javaMailSender;

    @Override
    public void send(String to, String body, String topic) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("findjobcasemd6@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(topic);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);

    }
}

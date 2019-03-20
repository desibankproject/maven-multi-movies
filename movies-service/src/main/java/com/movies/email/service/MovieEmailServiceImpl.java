package com.movies.email.service;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("MovieEmailServiceImpl")
public class MovieEmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(MailVO mail) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.addAttachment("chang", new ClassPathResource("movie.jpg"));
        String inlineImage = "<img src=\"cid:chang\"></img><br/>";
        helper.setText(inlineImage + mail.getContent(), true);
        helper.setSubject(mail.getSubject());
        helper.setTo(mail.getTo());
        helper.setFrom(mail.getFrom());
        emailSender.send(message);
    }

}

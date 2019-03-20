package com.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movies.email.service.MailVO;
import com.movies.email.service.MovieEmailServiceImpl;

@SpringBootApplication
public class SpringBootStartMain  implements ApplicationRunner{
	
	@Autowired
	MovieEmailServiceImpl emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartMain.class, args);
	}
	
	@Override
    public void run(ApplicationArguments args) throws Exception {
           System.out.println(")@#)@)Sending email@)@)@");
           MailVO mail = new MailVO();
            mail.setFrom("nagen@synergisticit.com");
            mail.setTo("synergisticsessionusc11@gmail.com");
            mail.setSubject("Sending Email with Inline Attachment Example");
            mail.setContent("This tutorial demonstrates how to send an email with inline attachment using Spring Framework.");
            emailService.sendSimpleMessage(mail);
    }


}

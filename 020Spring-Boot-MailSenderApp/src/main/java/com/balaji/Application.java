package com.balaji;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	 @Override
	    public void run(String... args) {

	        System.out.println("Sending Email...");

	       
			
	           // sendEmail();
	            try {
					sendEmailWithAttachment();
				} catch (MessagingException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	      

	        System.out.println("Done");

	    }

	    void sendEmail() {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("vemulapulendar@gmail.com", "balajig8086@gmail.com");

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);

	    }

	    void sendEmailWithAttachment() throws MessagingException, IOException {

	        MimeMessage msg = javaMailSender.createMimeMessage();

	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo("vemulapulendar@gmail.com");

	        helper.setSubject("Testing from Spring Boot");

	        // default = text/plain
	        //helper.setText("Check attachment for image!");

	        // true = text/html
	        helper.setText("<h1>Check attachment for image!</h1>", true);

	        helper.addAttachment("my_photo.jpg", new ClassPathResource("dhoni.jpg"));

	        javaMailSender.send(msg);

	    }
	
	
	

}

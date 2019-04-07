package com.web.restfulwebservices.services;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.web.restfulwebservices.Dao.HelloDao;
import com.web.restfulwebservices.model.Merchant;

@Service
public class HelloServiceImpl implements HelloService {
@Autowired
	HelloDao helloDao;

@Autowired
JavaMailSender mailSender;
	@Override
	public List<Merchant> display() {
		System.out.println("in the service");
//		sendMail();
		return helloDao.display();
	}
	private void sendMail() {
		MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message);
		        try {
					helper.setTo("adhikari8142@gmail.com");
					 helper.setText("How are you?");
				        helper.setSubject("Hi");
				} catch (MessagingException e) {
					System.out.println("error : "+e.getMessage());
				}
		        mailSender.send(message);

		       
	}

}

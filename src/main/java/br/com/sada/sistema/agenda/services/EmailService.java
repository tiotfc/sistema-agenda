package br.com.sada.sistema.agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.dto.EmailInput;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void enviaEmail(EmailInput email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("henrique.tio@gmail.com");
		mailMessage.setSubject(email.getAssunto());
		mailMessage.setText(email.getCorpo());
		mailMessage.setTo(email.getPara());
		mailSender.send(mailMessage);
	}
	
}

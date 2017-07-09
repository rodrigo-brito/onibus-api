package br.com.sabaramais.onibus.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabaramais.onibus.entity.MailPayload;


@RestController
@RequestMapping("/msg")
public class EmailController {
	
	@Value("${mail.from}")
	private String fromMail;
	@Value("${mail.password}")
	private String passwordMail;
	@Value("${mail.to}")
	private String toMail;
	
	private String constructMailMessage(String mail, String name, String message) {
		String mailMessage = "";
		if (mail != null && !mail.isEmpty()){
			mailMessage += "MAIL: "+ mail + "\n";
		}
		if (name != null && !name.isEmpty()){
			mailMessage += "NAME: "+ name + "\n";
		}
		mailMessage +=  "\nMESSAGE: "+ message;
		
		return mailMessage;
	}
	
	@RequestMapping(value="/mail", method = RequestMethod.POST)
	public void sendMessage(@RequestBody MailPayload mailPayload, HttpServletResponse response) {
		SimpleEmail mailer = new SimpleEmail();
		try {
			mailer.setFrom(fromMail);
			mailer.setSubject("Contato - Ônibus Sabará (WEB)");
			mailer.setMsg(constructMailMessage(mailPayload.getEmail(),
					mailPayload.getName(), mailPayload.getMessage()));
			mailer.setSSLOnConnect(true);
			mailer.setAuthentication(fromMail, passwordMail);
			mailer.setHostName("smtp.gmail.com");
			mailer.setSmtpPort(465);
			mailer.addTo(toMail);
			mailer.send();
		} catch (EmailException e) {
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); 
		}
		response.setStatus(HttpServletResponse.SC_CREATED);
	}
}

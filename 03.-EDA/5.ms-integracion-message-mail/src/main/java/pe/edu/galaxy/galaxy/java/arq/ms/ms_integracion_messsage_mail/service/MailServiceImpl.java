package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
	
	//private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String  mailFromUserName;

	@Override
	public void send(ClienteMessage clienteMessage) throws MailException {
		// TODO Auto-generated method stub
		try {
			
			log.info("Enviando mail a.. {}", clienteMessage);
			
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
//			messageHelper.setSubject("Bienvenido a la empresa Golden S.A.C");
//
//			String body = "<h1>Bienvenido</h1>" + "<p>"+"estimado cliente "+clienteMessage.getRazonSocial() + " bienvenido a la empresa Golden S.A.C"+"</p>"
//					   + "Realize el seguimento en https://www.galaxy.edu.pe/reclamos"
//					   + "Vistenos en <a href='https://www.galaxy.edu.pe'>Galaxy Training</a>" + "<br/><br/>";
//
//
//			messageHelper.setText(body, true);
//			messageHelper.setFrom(mailFromUserName);
//			messageHelper.setTo(clienteMessage.getCorreo());
//
//			mailSender.send(message);
			
			log.info("Mail enviado exitosamente");
		} catch (Exception ex) {
			log.error("Error al enviar mail a {}", clienteMessage);
		}
	}

}

package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.service;


import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage;

public interface MailService {
	
	void send(ClienteMessage clienteMessage)throws MailException;
	
}

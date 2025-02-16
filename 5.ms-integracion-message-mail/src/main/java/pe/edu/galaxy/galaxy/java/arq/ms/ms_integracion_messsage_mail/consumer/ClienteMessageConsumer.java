package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.consumer;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage;

public interface ClienteMessageConsumer {

	void readMessage(ClienteMessage clienteMessage) throws MessageException;
}

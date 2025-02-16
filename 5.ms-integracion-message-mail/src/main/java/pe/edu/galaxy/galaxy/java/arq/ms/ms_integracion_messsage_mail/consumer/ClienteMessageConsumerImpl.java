package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.service.MailService;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClienteMessageConsumerImpl implements ClienteMessageConsumer {
	
	private final MailService mailService;

	@KafkaListener(id = "clientes_id", 
			topics = "${kafka.topic.topic-clientes}",
			groupId = "${kafka.group.group-clientes-id}",
			containerFactory = "clientekafkaListenerContainerFactory")
	
	@Override
	public void readMessage(@Payload ClienteMessage clienteMessage) {
		
		try {
			log.info("ClienteMessageConsumerImpl...{}",clienteMessage.toString());
			
			// Send Mail
			mailService.send(clienteMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}

package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.consumer;


/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.kafka.support.KafkaHeaders;
*/
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.consumer.feing.MessageCommandFeingService;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;


@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoConsumerImpl implements PedidoConsumer{
	
	private final MessageCommandFeingService msIntegracionMessageCommandFeingService;
	
	// Resillence, Retry, Auditoria
	
	@KafkaListener(id = "pedido_id", topics = "${kafka.topic.topic-pedido-resumen}",groupId = "${kafka.group.group-pedido-id}",containerFactory = "pedidokafkaListenerContainerFactory")
	@Override
	public void readMessage(@Payload PedidoResumenMessage pedidoResumenMessage) {
	
		log.info("ms-integracion-message-consumer PedidoConsumer ...{}",pedidoResumenMessage);
		//log.info(pedidoResumenMessage.toString());
		
		msIntegracionMessageCommandFeingService.save(pedidoResumenMessage);		
	}

}

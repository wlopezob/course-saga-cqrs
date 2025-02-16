package pe.edu.galaxy.training.java.sb.ms.poc_kafka_consumer_v1.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.poc_kafka_consumer_v1.message.PedidoResumenMessage;


@Slf4j
@Service
public class PedidoConsumerImpl implements PedidoConsumer{

	@KafkaListener(id = "pedido_id", 
			topics = "${kafka.topic.topic-pedido-resumen}",
			groupId = "${kafka.group.group-pedido-id}",
			containerFactory = "pedidokafkaListenerContainerFactory")
	
	@Override
	public void readMessage(@Payload PedidoResumenMessage pedidoResumenMessage) {
	
		log.info("...");
		log.info(pedidoResumenMessage.toString());

	}
	   
}

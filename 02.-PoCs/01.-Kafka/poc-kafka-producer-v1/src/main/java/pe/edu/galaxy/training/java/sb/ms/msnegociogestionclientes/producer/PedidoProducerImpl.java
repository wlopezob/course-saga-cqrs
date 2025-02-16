package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;

@Service
public class PedidoProducerImpl implements PedidoProducer {

	private Logger logger = Logger.getLogger(PedidoProducer.class.getName());
	
	private final KafkaTemplate<String, PedidoResumenMessage> kafkaTemplate;
	
	@Value("${kafka.topic.topic-pedido-resumen}")
	private String topic;
	
	public PedidoProducerImpl(KafkaTemplate<String, PedidoResumenMessage> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	@Override
	public Boolean sendMessage(PedidoResumenMessage pedidoResumenMessage) throws ProducerException {
		try {
			
			logger.info("Mensaje enviado"+ pedidoResumenMessage);
			
			this.kafkaTemplate.send(topic, String.valueOf(pedidoResumenMessage.getId()), pedidoResumenMessage);
			
			return true;
		} catch (Exception e) {
			throw new ProducerException(e);
		}
	}
	
}

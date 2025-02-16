package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoProducerImpl implements PedidoProducer {

	private final KafkaTemplate<String, PedidoResumenMessage> kafkaTemplate;

	@Value("${kafka.topic.topic-pedido-resumen}")
	private String topic;

	@Override
	public Boolean sendMessage(PedidoResumenMessage pedidoMessage) throws ProducerException {
		try {
			log.info("Mensaje enviado : {}", pedidoMessage);
			this.kafkaTemplate.send(topic,String.valueOf(pedidoMessage.getIdPedido()), pedidoMessage); //Resillencia Callback() - Retry -  // Error (No_SQL) - Succesulf
			return true;
		} catch (Exception e) {
			throw new ProducerException(e);
		}
	}
	
}

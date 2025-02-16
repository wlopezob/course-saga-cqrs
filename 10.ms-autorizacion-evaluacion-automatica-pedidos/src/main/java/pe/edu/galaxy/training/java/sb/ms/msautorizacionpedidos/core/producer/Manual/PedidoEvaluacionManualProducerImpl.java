package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.Manual;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoEvaluacionManualProducerImpl implements PedidoEvaluacionManualProducer {

	private final KafkaTemplate<String, PedidoAutorizacionMessage> kafkaTemplate;

	@Value("${kafka.topic.topic-pedido-autorizacion-pendiente-manual}")
	private String topic;

	@Override
	public Boolean sendMessage(PedidoAutorizacionMessage pedidoAutorizacionMessage) throws ProducerException {
		try {
			log.info("Mensaje enviado : {}", pedidoAutorizacionMessage);
			this.kafkaTemplate.send(topic, pedidoAutorizacionMessage);
			return true;
		} catch (Exception e) {
			throw new ProducerException(e);
		}
	}
	
}

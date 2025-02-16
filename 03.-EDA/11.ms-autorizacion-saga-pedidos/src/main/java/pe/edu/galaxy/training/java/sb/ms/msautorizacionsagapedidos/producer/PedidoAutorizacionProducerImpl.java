package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons.PedidoSituacionEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.PedidoSAGAGestion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoAutorizacionProducerImpl implements PedidoAutorizacionProducer {

	private final KafkaTemplate<String, PedidoAutorizacionMessage> kafkaTemplate;
	
	private final PedidoSAGAGestion pedidoSAGAGestion;

	@Value("${kafka.topic.topic-pedido-autorizacion-pendiente-automatico}")
	private String topic;

	@Override
	public Boolean sendMessage(PedidoAutorizacionMessage pedidoMessage) throws ProducerException {
		try {
			
			log.info("Mensaje enviado : {}", pedidoMessage);
			
			this.kafkaTemplate.send(topic,String.valueOf(pedidoMessage.getIdPedido()), pedidoMessage);
			
			this.pedidoSAGAGestion.updateSituacion(PedidoSituacionEnum.EVALUACION, pedidoMessage.getIdPedido());
			
			return true;
		} catch (Exception e) {
			throw new ProducerException(e);
		}
	}
	
}

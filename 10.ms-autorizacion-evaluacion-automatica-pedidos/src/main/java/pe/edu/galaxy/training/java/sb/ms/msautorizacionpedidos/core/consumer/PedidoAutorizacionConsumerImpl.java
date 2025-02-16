package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.consumer;


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
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.aprobacion.PedidoAprobacion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoAutorizacionConsumerImpl implements PedidoAutorizacionConsumer{
	
	
	//private final MessageCommandFeingService msIntegracionMessageCommandFeingService;
	
	private final PedidoAprobacion pedidoAprobacion;
	
	@KafkaListener(id = "kafka.topic.topic-pedido-autorizacion-pendiente-automatico_id", 
			topics = "${kafka.topic.topic-pedido-autorizacion-pendiente-automatico}",
			groupId = "${kafka.group.group-pedido-autorizacion-pendiente-automatico}",
			containerFactory = "pedidokafkaListenerContainerFactory")
	@Override
	public void readMessage(@Payload PedidoAutorizacionMessage pedidoAutorizacionMessage) {
	
		log.info("ms-autorizacion-evaluacion-pedidos PedidoAutorizacionConsumer ...");
		log.info(pedidoAutorizacionMessage.toString());
		
		//msIntegracionMessageCommandFeingService.save(pedidoAutorizacionMessage);
		
		Boolean sw=this.pedidoAprobacion.aprobar(pedidoAutorizacionMessage);
		
		if(!sw) {
			// TODO 
		}
		
		
		//kafka.topic.topic-pedido-autorizacion-evaluado

	}


}

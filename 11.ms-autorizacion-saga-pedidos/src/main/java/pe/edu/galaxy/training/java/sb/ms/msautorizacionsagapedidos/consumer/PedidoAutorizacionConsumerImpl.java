package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.consumer;


import org.springframework.kafka.annotation.DltHandler;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.kafka.support.KafkaHeaders;
*/
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.exceptions.RetryableMessagingException;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.PedidoSAGAGestion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoAutorizacionConsumerImpl implements PedidoAutorizacionConsumer{
	
	private final PedidoSAGAGestion pedidoSAGAGestion;
	
	/*
    @RetryableTopic(
            attempts = "#{'${kafka.retry.maxRetryAttempts}'}",
            autoCreateTopics = "#{'${kafka.retry.autoCreateRetryTopics}'}",
            backoff = @Backoff(delayExpression = "#{'${kafka.retry.retryIntervalMilliseconds}'}",
            multiplierExpression = "#{'${kafka.retry.retryBackoffMultiplier}'}"),
            include = {RetryableMessagingException.class},
            timeout = "#{'${kafka.retry.maxRetryDurationMilliseconds}'}",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)*/
    
	@KafkaListener(id = "kafka.group.group-pedido-autorizacion-evaluado_id", topics = "${kafka.topic.topic-pedido-autorizacion-evaluado}",
			groupId = "${kafka.group.group-pedido-autorizacion-evaluado}",containerFactory = "pedidokafkaListenerContainerFactory")
	@Override
	public void readMessage(@Payload final PedidoAutorizacionMessage pedidoAutorizacionMessage) {
	
		log.info("ms-autorizacion-saga-pedidos - evaluado-automatico- PedidoAutorizacionConsumer ...");
		log.info(pedidoAutorizacionMessage.toString());
		
		pedidoSAGAGestion.evaluation(pedidoAutorizacionMessage);
	}

	/*
    @DltHandler // DLT
    public void pedidoAutorizacionDLTMessage(PedidoAutorizacionMessage pedidoAutorizacionMessage, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.error("Event from topic "+topic+" is dead lettered - event:" + pedidoAutorizacionMessage);
    }*/

}

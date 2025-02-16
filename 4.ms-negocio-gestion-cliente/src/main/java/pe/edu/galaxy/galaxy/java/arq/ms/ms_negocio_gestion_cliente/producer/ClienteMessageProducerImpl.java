package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.producer;

import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.messages.ClienteMessage;

@Component
@Slf4j
public class ClienteMessageProducerImpl implements ClienteMessageProducer {


  private final KafkaTemplate<String, ClienteMessage> kafkaTemplate;

  @Value("${kafka.topic.topic-clientes}")
  private String topic;

  public ClienteMessageProducerImpl(KafkaTemplate<String, ClienteMessage> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void send(ClienteMessage clienteMessage) throws MessageException {
    try {
      log.info("Mensaje enviado" + clienteMessage);

      this.kafkaTemplate.send(topic, String.valueOf(clienteMessage.getId()), clienteMessage);
    }catch (Exception e){
        throw new MessageException("Error al enviar el mensaje", e);
      }

  }

}

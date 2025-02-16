package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.listeners;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.messages.ClienteMessage;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.producer.ClienteMessageProducer;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.producer.MessageException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteEventListener {

  private final ClienteMessageProducer clienteMessageProducer;

  @EventListener
  public void eventListener(ClienteMessage clienteMessage) throws MessageException {
   log.info("Evento de cliente {}", clienteMessage);
    try {
      clienteMessageProducer.send(clienteMessage);
    } catch (MessageException e) {
      throw new MessageException(e);
    }
  }
}

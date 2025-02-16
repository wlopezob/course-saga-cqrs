package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.producer;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.messages.ClienteMessage;

public interface ClienteMessageProducer {

  void send(ClienteMessage clienteMessage) throws MessageException;
}

package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;

@FunctionalInterface
public interface PedidoProducer {

	Boolean sendMessage(PedidoResumenMessage  pedidoMessage) throws ProducerException;
	
}

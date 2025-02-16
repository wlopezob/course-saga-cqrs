package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;

public interface PedidoProducer {

	Boolean sendMessage(PedidoResumenMessage  pedidoResumenMessage) throws ProducerException;
	
}

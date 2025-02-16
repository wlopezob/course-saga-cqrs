package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.consumer;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;

@FunctionalInterface
public interface PedidoConsumer {

	void readMessage(PedidoResumenMessage  pedidoResumenMessage);
	
}

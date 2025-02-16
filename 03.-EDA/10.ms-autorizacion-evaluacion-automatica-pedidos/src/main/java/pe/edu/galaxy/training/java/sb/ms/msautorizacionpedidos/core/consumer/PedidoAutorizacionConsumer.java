package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.consumer;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;

@FunctionalInterface
public interface PedidoAutorizacionConsumer {

	void readMessage(PedidoAutorizacionMessage  pedidoAutorizacionMessage);
	
}

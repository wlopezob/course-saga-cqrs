package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.consumer;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@FunctionalInterface
public interface PedidoAutorizacionConsumer {

	void readMessage(PedidoAutorizacionMessage  pedidoAutorizacionMessage);
	
}

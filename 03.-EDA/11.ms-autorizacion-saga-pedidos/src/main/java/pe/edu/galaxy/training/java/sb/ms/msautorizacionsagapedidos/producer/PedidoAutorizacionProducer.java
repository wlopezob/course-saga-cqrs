package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.producer;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@FunctionalInterface
public interface PedidoAutorizacionProducer {

	Boolean sendMessage(PedidoAutorizacionMessage  pedidoMessage) throws ProducerException;
	
}

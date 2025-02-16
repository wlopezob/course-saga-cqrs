package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.automatica;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.Manual.ProducerException;

public interface PedidoEvaluacionAutomaticaProducer {

	Boolean sendMessage(PedidoAutorizacionMessage  pedidoAutorizacionMessage) throws ProducerException;
	
}

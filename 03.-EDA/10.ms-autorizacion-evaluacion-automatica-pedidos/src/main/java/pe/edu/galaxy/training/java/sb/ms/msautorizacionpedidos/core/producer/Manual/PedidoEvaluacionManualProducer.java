package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.Manual;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;

public interface PedidoEvaluacionManualProducer {

	Boolean sendMessage(PedidoAutorizacionMessage  pedidoAutorizacionMessage) throws ProducerException;
	
}

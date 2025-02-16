package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons.PedidoSituacionEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

public interface PedidoSAGAGestion {

	Boolean updateSituacion(PedidoSituacionEnum situacion, Long id);
	
	Boolean evaluation(PedidoAutorizacionMessage pedidoAutorizacionMessage);
	
	Boolean updateReservaAndStock(Long idPedido, Integer swIncrement);
}

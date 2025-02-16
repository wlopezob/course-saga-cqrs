package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.aprobacion;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;

@FunctionalInterface
public interface PedidoAprobacion {

	boolean aprobar(PedidoAutorizacionMessage pedidoAutorizacionMessage);
}

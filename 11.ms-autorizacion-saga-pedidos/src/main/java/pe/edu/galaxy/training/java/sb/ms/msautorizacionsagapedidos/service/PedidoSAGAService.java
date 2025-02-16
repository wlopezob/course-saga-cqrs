package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.service;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@FunctionalInterface
public interface PedidoSAGAService {

	Boolean sendMessage(PedidoAutorizacionMessage pedidoAutorizacionMessage) throws PedidoSAGAServiceException;
}
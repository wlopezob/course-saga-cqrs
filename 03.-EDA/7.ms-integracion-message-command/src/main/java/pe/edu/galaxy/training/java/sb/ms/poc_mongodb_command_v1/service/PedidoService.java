package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service;

import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;

@FunctionalInterface
public interface PedidoService {

	Boolean savePedidoResumen(PedidoResumenDocument pedidoResumenDocument) throws ServiceException;
	
}

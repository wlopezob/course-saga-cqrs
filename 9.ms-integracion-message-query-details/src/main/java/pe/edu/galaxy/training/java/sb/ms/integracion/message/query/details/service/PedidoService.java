package pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.service;

import java.util.List;

import pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.document.PedidoResumenDocument;

public interface PedidoService {

	List<PedidoResumenDocument> findAll() throws ServiceException;
	
	List<PedidoResumenDocument> findByPedidoGlosaLike(String glosa) throws ServiceException;
	
}

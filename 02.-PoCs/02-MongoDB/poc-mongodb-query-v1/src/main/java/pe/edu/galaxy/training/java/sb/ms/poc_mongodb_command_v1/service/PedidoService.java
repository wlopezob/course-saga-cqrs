package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service;

import java.util.List;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;

public interface PedidoService {

	List<PedidoResumenDocument> findAll() throws ServiceException;
	
	List<PedidoResumenDocument> findByPedidoGlosaLike(String glosa) throws ServiceException;
	
}

package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.repository.PedidoResumenRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	private final PedidoResumenRepository pedidoResumenRepository;

	public PedidoServiceImpl(PedidoResumenRepository pedidoResumenRepository) {
		this.pedidoResumenRepository=pedidoResumenRepository;
	}

	@Override
	public List<PedidoResumenDocument> findAll() throws ServiceException{
		try {
			return this.pedidoResumenRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PedidoResumenDocument> findByPedidoGlosaLike(String glosa) throws ServiceException{
		try {
			return this.pedidoResumenRepository.findByPedidoGlosaLike(glosa);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}

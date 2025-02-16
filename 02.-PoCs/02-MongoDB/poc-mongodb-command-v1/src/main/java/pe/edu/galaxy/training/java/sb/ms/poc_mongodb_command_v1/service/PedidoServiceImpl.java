package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service;

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
	public Boolean savePedidoResumen(PedidoResumenDocument pedidoResumenDocument) throws ServiceException{
		try {
			this.pedidoResumenRepository.save(pedidoResumenDocument);
			return true;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}

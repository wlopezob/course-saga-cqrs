package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.commons.PedidoSituacionEnum;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoItemDTO;

public interface PedidoService {
	
	Optional<PedidoDTO> findById(Long id) throws PedidoException; // API Composite

	List<PedidoDTO> findAll() throws PedidoException;
	
	Long save(PedidoDTO pedidoDTO)throws PedidoException;
	
	void updateSituacion(PedidoSituacionEnum situacion, Long id) throws PedidoException;
	
	List<PedidoItemDTO> findDetalleByIdPedido(Long idPedido) throws PedidoException; 
}

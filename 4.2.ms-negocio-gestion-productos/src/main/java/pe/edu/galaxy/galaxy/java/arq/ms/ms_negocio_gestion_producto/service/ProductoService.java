package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_producto.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_producto.dto.ProductoDTO;

public interface ProductoService {
	
	Optional<ProductoDTO> findById(Long id) throws ProductoException;

	List<ProductoDTO> findAll() throws ProductoException;
	
	Long save(ProductoDTO clienteDTO)throws ProductoException;
	
	List<ProductoDTO> findByIds(List<Long> ids) throws ProductoException;
	
	void updateStock(Integer stock, Long id) throws ProductoException;
	
	void updateReserva(Integer reserva, Long id) throws ProductoException;
	
}

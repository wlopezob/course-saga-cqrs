package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.commons.PedidoSituacionEnum;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoItemDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoItemEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events.PedidoEventApplication;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events.PedidoEventModel;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.mapper.PedidoMapper;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.respository.PedidoItemRepository;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.respository.PedidoRepository;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.feing.ClienteFeingServiceClient;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteService;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.productos.feing.ProductoDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.productos.feing.ProductoFeingService;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidoRepository pedidoRepository;
	private final PedidoItemRepository pedidoItemRepository;
	private final PedidoMapper pedidoMapper;
	private final ClienteService clienteService;
	private final ProductoFeingService productoFeingService;
	private final ApplicationEventPublisher publisher;
	
	@Value("${custom.igv}")
	private Double prmIgv;
	
	private ClienteDTO tpmClienteDTO;

	@Override
	public Optional<PedidoDTO> findById(Long id) throws PedidoException {
		String msg = String.format("No existe pedido con id => {}", id);
		PedidoEntity pedidoEntity = this.pedidoRepository.findById(id).orElseThrow(() -> new PedidoException(msg));
		PedidoDTO pedidoDTO = pedidoMapper.toDTO(pedidoEntity);
		// Call MS-Cliente
		/*
		ClienteClientDTO clienteClientDTO= clienteService.findById(id);
		if (!isNull(clienteClientDTO)) {
			ClienteDTO clienteDTO= ClienteDTO.builder().id(clienteClientDTO.getId()).razonSocial(clienteClientDTO.getRazonSocial()).ruc(clienteClientDTO.getRuc()).direccion(clienteClientDTO.getDireccion()).build();
			pedidoDTO.setCliente(clienteDTO);
		}*/
		ClienteDTO clienteDTO= clienteService.findById(pedidoEntity.getClienteId());
		log.info("clienteDTO => {}",clienteDTO);
		pedidoDTO.setCliente(clienteDTO);
		
		return Optional.ofNullable(pedidoDTO);
	}

	@Override
	public List<PedidoDTO> findAll() throws PedidoException {
		return pedidoMapper.toLstDTO(pedidoRepository.findAll());
	}

	@Override
	public Long save(PedidoDTO pedidoDTO) throws PedidoException {
		/*
		PedidoEntity pedidoEntity= pedidoRepository.save(pedidoMapper.toEntity(pedidoDTO));	
		if (isNull(pedidoEntity)) {
			throw new PedidoException("Error al resgitrar pedido");
		}
		return pedidoEntity.getId();
		*/

		log.info("PedidoDTO, {}", pedidoDTO);
		// Business Logic
		try {

			PedidoEntity pedidoEntity = pedidoMapper.toEntity(pedidoDTO);

			this.validar(pedidoEntity);

			// Calcular los totales del Detalle

			for (PedidoItemEntity pedidoItemEntity : pedidoEntity.getItems()) {
				this.pedidoDetalleCalcularTotales(pedidoItemEntity, pedidoEntity);
				//this.actualizarStock(-pedidoDetalleEntity.getCantidad(), pedidoDetalleEntity.getIdProducto());
				this.actualizarReservaStock(pedidoItemEntity.getCantidad(), pedidoItemEntity.getProductoId());
				pedidoItemEntity.setEstado("1");
			}

			// Calcular los totales de la cabecera

			this.pedidoCabeceraCalcularTotales(pedidoEntity);

			log.info("PedidoEntity- con cálculos {}", pedidoEntity);

			pedidoEntity.setEstado("1");
			PedidoEntity retPedidoEntity = pedidoRepository.save(pedidoEntity);

			if (isNull(retPedidoEntity)) {
				throw new PedidoException("Error al generar el pedido");
			}
			Long id=retPedidoEntity.getId();
			log.info("Id Pedido, {}", id);
			if(!isNull(id)) {
				// Event
				// actualizarReservaStock
				PedidoEventModel pedidoEventModel= pedidoMapper.toEvent(retPedidoEntity);
				pedidoEventModel.setCliente(tpmClienteDTO);
				publisher.publishEvent(new PedidoEventApplication<PedidoEventModel> (pedidoEventModel));
				return id;
			}
			
			throw new PedidoException("Error al generar el pedido");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new PedidoException("Error al generar el pedido", e);
		}
		
	}
	@Override
	public List<PedidoItemDTO> findDetalleByIdPedido(Long idPedido) throws PedidoException {
		try {
			
			List<PedidoItemEntity> lstPedidoItemEntity= this.pedidoItemRepository.findByIdPedido(idPedido);
			
			return pedidoMapper.toLstItemDTO(lstPedidoItemEntity);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new PedidoException("Error al actualizar situacion de pedido", e);
		}
	}
	
	@Transactional
	@Override
	public void updateSituacion(PedidoSituacionEnum situacion, Long id) throws PedidoException{
		
		try {
			this.pedidoRepository.updateSituacion(situacion.getValor(), id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new PedidoException("Error al actualizar situacion de pedido", e);
		}
		
	}
	
	// Metodos utilitarios - privados
	
	private void validar(PedidoEntity pedidoEntity) throws PedidoException {
		if (isNull(pedidoEntity)) {
			throw new PedidoException("La cabecera del pedido es nula");
		}

		if (isNull(pedidoEntity.getItems())) {
			throw new PedidoException("El detalle del pedido es nulo");
		}

		Long idCliente = pedidoEntity.getClienteId();

		if (isNull(idCliente)) {
			throw new PedidoException("El cliente es requerido");
		}

		ClienteDTO clienteDTO = clienteService.findById(idCliente);
		
		if (isNull(clienteDTO)) {
			throw new PedidoException(String.format("No existe cliente con el id = %d", idCliente));
		}
		this.tpmClienteDTO=clienteDTO;
	}
	
	private void pedidoCabeceraCalcularTotales(PedidoEntity pedidoEntity) {
		Double subTotal = 0.0;
		Double igv = 0.0;
		Double total = 0.0;
		for (PedidoItemEntity pde : pedidoEntity.getItems()) {
			subTotal += pde.getSubTotal();
			igv += pde.getIgv();
			total += pde.getTotal();
		}
		pedidoEntity.setSubTotal(subTotal);
		pedidoEntity.setIgv(igv);
		pedidoEntity.setTotal(total);
	}
	
	private void pedidoDetalleCalcularTotales(PedidoItemEntity pedidoItemEntity, PedidoEntity pedidoEntity) throws PedidoException {
		pedidoItemEntity.setPedido(pedidoEntity);
		ProductoDTO productoDTO = this.getProducto(pedidoItemEntity);
		Double precio = productoDTO.getPrecio();
		pedidoItemEntity.setPrecio(precio);
		Double subTotal = pedidoItemEntity.getCantidad() * precio;
		pedidoItemEntity.setSubTotal(subTotal);
		Double igv=subTotal*prmIgv;
		pedidoItemEntity.setIgv(igv);
		pedidoItemEntity.setTotal((subTotal+igv));		
	}
	
	private ProductoDTO getProducto(PedidoItemEntity pedidoItemEntity) throws PedidoException {

		Long idProducto = pedidoItemEntity.getProductoId();

		if (isNull(idProducto)) {
			throw new PedidoException("El producto es requerido");
		}

		ResponseEntity<ProductoDTO> reProductoDTO = productoFeingService.findById(idProducto);

		if (isNull(reProductoDTO) || isNull(reProductoDTO.getBody()) || isNull(reProductoDTO.getBody().getId())) {
			throw new PedidoException(String.format("No existe producto con el id = %d", idProducto));
		}
		return reProductoDTO.getBody();
	}
	
	private void actualizarReservaStock(Integer valor, Long idProducto) {
		productoFeingService.updateStock(-valor, idProducto);
		productoFeingService.updateReserva(+valor, idProducto);
	}
	
}

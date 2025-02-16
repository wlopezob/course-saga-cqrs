package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons.PedidoSituacionEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.pedido.dto.PedidoDetalleDTO;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.pedido.feing.PedidoFeingService;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.producto.feing.ProductoFeingService;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;

@Slf4j
@Component
public class PedidoSAGAGestionImpl implements PedidoSAGAGestion {

	private final PedidoFeingService pedidoFeingService;
	private final ProductoFeingService productoFeingService;


	public PedidoSAGAGestionImpl(PedidoFeingService pedidoFeingService,ProductoFeingService productoFeingService) {
		this.pedidoFeingService = pedidoFeingService;
		this.productoFeingService=productoFeingService;
	}

	@Override
	public Boolean updateSituacion(PedidoSituacionEnum situacion, Long id) {
		try {
			log.info("PedidoGestionImpl - updateSituacion... {},{}",situacion, id);
			pedidoFeingService.updateSituacion(situacion.getValor(), id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean evaluation(PedidoAutorizacionMessage pedidoAutorizacionMessage) {
		try {
			
			PedidoSituacionEnum situacion = pedidoAutorizacionMessage.getSituacion();
			
			log.info("SAGA - evaluation...situacion, {}",situacion);
			
			Integer swIncrement=1;
			
			Long idPedido=pedidoAutorizacionMessage.getIdPedido();
			
			switch (situacion) {
				case APROBADO: {
					log.info("evaluación...APROBADO");
					this.updateSituacion(situacion, idPedido);
					this.updateReservaAndStock(idPedido, swIncrement*(-1)); 
					break;
				}
				case RECHAZADO: {
					log.info("evaluación...RECHAZADO");
					this.updateSituacion(situacion, idPedido);
					this.updateReservaAndStock(idPedido, swIncrement*(1)); 
					break;
				}
				default:
					break;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateReservaAndStock(Long idPedido, Integer swIncrement) {
		log.info("PedidoGestionImpl - updateReservaAndStock... {},{}",swIncrement, idPedido);
		List<PedidoDetalleDTO> lstPedidoDetalleDTO=	 pedidoFeingService.findDetalleById(idPedido).getBody();
		lstPedidoDetalleDTO.forEach(e-> {
			log.info("Detalle,{}",e);
			productoFeingService.updateReserva((-1)*(e.getCantidad()), e.getIdProducto());
			productoFeingService.updateStock((swIncrement)*e.getCantidad(), e.getIdProducto());
		});
		return null;
	}

}

package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.mapper;

import java.util.List;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoItemDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoItemEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events.PedidoEventModel;

public interface PedidoMapper {

	PedidoDTO toDTO(PedidoEntity e);
	
	PedidoEntity toEntity(PedidoDTO d);
	
	PedidoEventModel toEvent(PedidoEntity e);
	
	PedidoItemDTO toDTO(PedidoItemEntity e);

	List<PedidoDTO> toLstDTO(List<PedidoEntity> lstE);
	
	List<PedidoItemDTO> toLstItemDTO(List<PedidoItemEntity> lstE);

}

package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.mapper;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto.PedidoItemDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoItemEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events.PedidoEventModel;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;

@RequiredArgsConstructor
@Component
public class PedidoMapperImpl implements PedidoMapper {
	
	public final ModelMapper modelMapper;

	@Override
	public PedidoDTO toDTO(PedidoEntity e) {
		return modelMapper.map(e, PedidoDTO.class);
	}

	@Override
	public List<PedidoDTO> toLstDTO(List<PedidoEntity> lstE) {
		
		return lstE.stream().map(e-> this.toDTO(e)).toList();
	}

	@Override
	public PedidoEntity toEntity(PedidoDTO d) {
		return modelMapper.map(d, PedidoEntity.class);
	}

	@Override
	public PedidoEventModel toEvent(PedidoEntity e) {
		return PedidoEventModel
				.builder()
				.id(e.getId())
				.cliente(ClienteDTO.builder().id(e.getClienteId()).build())
				.glosa(e.getGlosa())
				.fechaRegistro(e.getFechaPedido())
				.subTotal(e.getSubTotal())
				.igv(e.getIgv())
				.total(e.getTotal())
				.estado(e.getEstado())
				.build();
	}

	@Override
	public List<PedidoItemDTO> toLstItemDTO(List<PedidoItemEntity> lstE) {
		return lstE.stream().map(e-> this.toDTO(e)).toList();
	}

	@Override
	public PedidoItemDTO toDTO(PedidoItemEntity e) {
		return modelMapper.map(e, PedidoItemDTO.class);
	}

}

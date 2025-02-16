package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.autorizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.commons.PedidoSituacionEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoAutorizacionMessage {

	private Long idPedido;
			
	private String fechaRegistro;
		
	private Double total;
	
	private Long idCliente;
	
	private PedidoSituacionEnum situacion;

}


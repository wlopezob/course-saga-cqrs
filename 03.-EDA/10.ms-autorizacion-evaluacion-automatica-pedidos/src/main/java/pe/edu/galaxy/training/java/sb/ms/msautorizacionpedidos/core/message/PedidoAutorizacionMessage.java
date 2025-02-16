package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoRangoEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoSituacionEnum;

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

	private PedidoRangoEnum nivelAprobacion;
}


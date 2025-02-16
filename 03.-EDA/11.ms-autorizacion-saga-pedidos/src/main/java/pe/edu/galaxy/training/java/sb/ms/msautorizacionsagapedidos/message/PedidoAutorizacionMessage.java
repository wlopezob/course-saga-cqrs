package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons.PedidoSituacionEnum;

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


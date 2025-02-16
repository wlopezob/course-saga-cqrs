package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResumenMessage {

	private Long idPedido;

	private String cliente;
			
	private String glosa;

	private String fechaRegistro;
	
	private Double subTotal;
	
	private Double igv;
	
	private Double total;


}


package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.messages.producer;

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
			
	private String glosa;

	private String fechaRegistro;
	
	private Double subTotal;
	
	private Double igv;
	
	private Double total;
	
	private String cliente;

}


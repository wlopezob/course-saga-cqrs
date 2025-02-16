package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.pedido.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDetalleDTO {

	private Long id;
	
	private Long idProducto;
	
	private Integer cantidad;
	
	private Double precio;
	
	private Double subTotal;
	
	private Double igv;
	
	private Double total;
	
	private String estado;
	
	
}


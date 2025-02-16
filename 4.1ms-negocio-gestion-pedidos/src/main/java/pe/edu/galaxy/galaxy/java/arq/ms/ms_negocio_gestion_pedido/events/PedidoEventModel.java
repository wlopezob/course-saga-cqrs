package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.commons.PedidoSituacionEnum;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEventModel {

	private Long id;
	
	private ClienteDTO cliente;
	
	private String glosa;

	private LocalDate fechaRegistro;
	
	private Double subTotal;
	
	private Double igv;
	
	private Double total;
	
	private String estado;
	
	private PedidoSituacionEnum situacion;
	
}

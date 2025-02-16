package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;

@Data
public class PedidoDTO{

	private Long id;
	
	private String glosa;
	
	private LocalDate fechaEntrega;

	private LocalDate fechaPedido;

	private Double subTotal;
	
	private Double descuento;

	private Double igv;
	
	private Double total;
	
	private ClienteDTO cliente;
	
	private List<PedidoItemDTO> items;
	
	private String situacion;

	private String estado;
	
}

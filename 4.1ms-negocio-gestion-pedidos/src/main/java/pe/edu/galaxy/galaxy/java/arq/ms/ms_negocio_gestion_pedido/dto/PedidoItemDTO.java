package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.dto;

import lombok.Data;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.productos.feing.ProductoDTO;

@Data
public class PedidoItemDTO{

	private Long id;
	
	private Double precio;
	
	private Integer cantidad;
	
	private Double subTotal;
	
	private Double descuento;

	private Double igv;
	
	private Double total;
	
	private ProductoDTO producto;
		
	private String situcion;

	private String estado;
	
}

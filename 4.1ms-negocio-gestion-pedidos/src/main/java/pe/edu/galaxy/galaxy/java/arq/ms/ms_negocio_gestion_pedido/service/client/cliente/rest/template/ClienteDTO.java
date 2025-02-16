package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO{

	private Long id;
	
	private String razonSocial;
	
	private String ruc;

	private String direccion;
	
	public String getRazonSocial() {
		return razonSocial.toUpperCase();
	}
	
}



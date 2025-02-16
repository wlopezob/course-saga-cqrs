
package  pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.feing;

import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;

@FeignClient(value = "clienteFeingServiceBackupOne", url ="${ms-negocio-gestion-clientes_backup.url}")
public interface ClienteFeingServiceBackupOne {

	@GetMapping(value = "/{id}")
	ClienteDTO findById(@PathVariable(value = "id") Long id);

}

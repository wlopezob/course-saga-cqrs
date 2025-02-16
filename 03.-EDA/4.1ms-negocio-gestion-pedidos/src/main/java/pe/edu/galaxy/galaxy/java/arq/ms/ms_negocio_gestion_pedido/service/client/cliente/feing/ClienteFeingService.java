package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;

@FeignClient(value = "ms-negocio-gestion-clientes",url = "${ms-negocio-gestion-clientes.url}")
public interface ClienteFeingService {

	@GetMapping(value = "/{id}")
	//@CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallbackMenory")
	ResponseEntity<ClienteDTO> findById(@PathVariable(value = "id") Long id);
	
	/*
	default ClienteDTO findByIdFallbackMenory(Exception exception) {
		return ClienteDTO.builder().id(99999L).razonSocial("Razon social demo - Feing").ruc("Sin ruc").build();
	}*/
	
	
}

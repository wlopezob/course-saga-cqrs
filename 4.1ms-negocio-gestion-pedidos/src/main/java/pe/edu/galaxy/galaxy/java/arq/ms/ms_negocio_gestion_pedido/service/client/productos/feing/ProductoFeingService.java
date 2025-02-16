package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.productos.feing;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "ms-negocio-gestion-productos",url = "${ms-negocio-gestion-productos.url}")
public interface ProductoFeingService {

	
	@GetMapping(value = "/{id}")
	@CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallbackMenory")
	ResponseEntity<ProductoDTO> findById(@RequestParam("id") Long id);
	
	@GetMapping(value = "/ids")
	@CircuitBreaker(name = "findByIds", fallbackMethod = "findByIdsFallbackMenory")
	ResponseEntity<List<ProductoDTO>> findByIds(@RequestParam("ids") List<Long> ids);

	@PostMapping("update-stock")
	ResponseEntity<Void> updateStock(@RequestParam("stock") Integer stock, @RequestParam("id") Long id);
	
	@PostMapping("/update-reserva")
	ResponseEntity<Void> updateReserva(@RequestParam("reserva") Integer reserva, @RequestParam("id") Long id);



	default ResponseEntity<List<ProductoDTO>> findByIdsFallbackMenory(Exception exception) {
		System.out.println("exception"+exception.getMessage());
		return ResponseEntity.ok(new ArrayList<ProductoDTO>());
	}
	

	default ResponseEntity<ProductoDTO> findByIdFallbackMenory(Exception exception) {
		System.out.println("exception"+exception.getMessage());
		return ResponseEntity.ok(new ProductoDTO());
	}
	
}

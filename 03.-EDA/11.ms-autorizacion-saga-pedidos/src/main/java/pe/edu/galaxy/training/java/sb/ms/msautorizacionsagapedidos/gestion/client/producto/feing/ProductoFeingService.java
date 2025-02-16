package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.producto.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-negocio-gestion-productos",url = "${ms-negocio-gestion-productos.url}")
public interface ProductoFeingService {
	
	@PostMapping("/update-stock")
	ResponseEntity<Void> updateStock(@RequestParam("stock") Integer stock, @RequestParam("id") Long id);
	
	@PostMapping("/update-reserva")
	ResponseEntity<Void> updateReserva(@RequestParam("reserva") Integer reserva, @RequestParam("id") Long id);

}

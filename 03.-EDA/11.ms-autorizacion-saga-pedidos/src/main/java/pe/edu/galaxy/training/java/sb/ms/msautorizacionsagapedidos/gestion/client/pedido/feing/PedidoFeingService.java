package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.pedido.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.client.pedido.dto.PedidoDetalleDTO;

@FeignClient(value = "ms-negocio-gestion-pedidos",url = "${ms-negocio-gestion-pedidos.url}")
public interface PedidoFeingService {

	@PostMapping("/updateSituacion")
	ResponseEntity<Void> updateSituacion(@RequestParam("situacion") Integer situacion,	@RequestParam("id") Long id);
	
	@GetMapping("/{idPedido}/detalle")
	public ResponseEntity<List<PedidoDetalleDTO>> findDetalleById(@PathVariable(name = "idPedido") Long idPedido);
	
}

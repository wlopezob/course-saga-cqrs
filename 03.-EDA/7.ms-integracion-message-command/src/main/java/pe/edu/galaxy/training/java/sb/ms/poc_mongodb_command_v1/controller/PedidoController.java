package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service.PedidoService;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service.ServiceException;

@RestController
@RequestMapping("/v1/pedidos/command")
public class PedidoController {
	
	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService=pedidoService;
	}
	
	
	@GetMapping
	public ResponseEntity<?> messageBody(){
		
		PedidoResumenDocument pedidoResumenDocument = new PedidoResumenDocument();
		pedidoResumenDocument.setIdPedido(1L);
		pedidoResumenDocument.setGlosa("Pedido de equipos de cómputo");
		pedidoResumenDocument.setFechaRegistro(LocalDate.now().toString());
		pedidoResumenDocument.setTotal(10_000.00);
		pedidoResumenDocument.setCliente("20544987304 -  Comercial Hermanos Casa S.A.");
		
		return ResponseEntity.ok(pedidoResumenDocument);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody PedidoResumenDocument pedidoResumenDocument){
		try {
			pedidoResumenDocument.setFechaIntegracion(LocalDateTime.now().toString());
			Boolean sw= pedidoService.savePedidoResumen(pedidoResumenDocument);
			if (!sw) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (ServiceException e) {
			e.printStackTrace();
			Map<String, String> ret= new HashMap<>();
			ret.put("error", "Error interno");
			return ResponseEntity.internalServerError().body(ret);
		}
	}

}

package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service.PedidoService;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.service.ServiceException;

@RestController
@RequestMapping("/v1/pedidos/query")
public class PedidoController {
	
	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService=pedidoService;
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			
			List<PedidoResumenDocument> lstPedidoResumenDocument= pedidoService.findAll();
			if (lstPedidoResumenDocument.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstPedidoResumenDocument);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			Map<String, String> ret= new HashMap<>();
			ret.put("error", "Error interno");
			return ResponseEntity.internalServerError().body(ret);
		}
	}
	
	@GetMapping("/by-glosa")
	public ResponseEntity<?> findByPedidoGlosaLike(@RequestParam(value = "glosa", defaultValue = "") String glosa){
		try {
			
			List<PedidoResumenDocument> lstPedidoResumenDocument= pedidoService.findByPedidoGlosaLike(glosa);
			if (lstPedidoResumenDocument.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstPedidoResumenDocument);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			Map<String, String> ret= new HashMap<>();
			ret.put("error", "Error interno");
			return ResponseEntity.internalServerError().body(ret);
		}
	}

}

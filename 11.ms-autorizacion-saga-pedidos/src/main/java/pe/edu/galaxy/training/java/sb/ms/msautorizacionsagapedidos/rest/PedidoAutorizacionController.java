package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.rest;

import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons.PedidoSituacionEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.gestion.PedidoSAGAGestion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.service.PedidoSAGAService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pedidos/autorizacion")
public class PedidoAutorizacionController{

	private final PedidoSAGAService pedidoSAGAService;
	
	private final PedidoSAGAGestion pedidoSAGAGestion;
	
	
		
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody PedidoAutorizacionMessage pedidoMessage){
		try {
			
			Boolean sw= pedidoSAGAService.sendMessage(pedidoMessage);
			if (!sw) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(null);
		}
	}
	
	@PostMapping("/updateSituacion")
	public ResponseEntity<?> updateSituacion(@RequestBody PedidoAutorizacionMessage pedidoMessage){
		try {
			pedidoSAGAGestion.evaluation(pedidoMessage);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(null);
		}
	}
	
	
	
	@GetMapping("get-data-demo")
	public ResponseEntity<?> messageBody(){
		
		PedidoAutorizacionMessage pedidoResumenMessage = new PedidoAutorizacionMessage();
		pedidoResumenMessage.setIdPedido(1L);
		pedidoResumenMessage.setFechaRegistro(LocalDate.now().toString());
		pedidoResumenMessage.setIdCliente(1L);
		pedidoResumenMessage.setTotal(5000D);
		pedidoResumenMessage.setSituacion(PedidoSituacionEnum.APROBADO);
		return ResponseEntity.ok(pedidoResumenMessage);
	}


}

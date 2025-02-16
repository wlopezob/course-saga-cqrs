package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.rest;

import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer.PedidoProducer;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pedidos/producer")
public class PedidoProducerController{

	private final PedidoProducer pedidoProducer;
	
	
	@GetMapping
	public ResponseEntity<?> messageBody(){
		
		PedidoResumenMessage pedidoResumenMessage = new PedidoResumenMessage();
		pedidoResumenMessage.setIdPedido(1L);
		pedidoResumenMessage.setGlosa("Pedido de equipos de cómputo");
		pedidoResumenMessage.setFechaRegistro(LocalDate.now().toString());
		pedidoResumenMessage.setSubTotal(10_000.00);
		pedidoResumenMessage.setIgv(1_800.00);
		pedidoResumenMessage.setTotal(11_800.00);
		pedidoResumenMessage.setCliente("20544987304 -  Comercial Hermanos Casa S.A.");
		
		return ResponseEntity.ok(pedidoResumenMessage);
	}

	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody PedidoResumenMessage pedidoMessage){
		try {
			
			Boolean sw= pedidoProducer.sendMessage(pedidoMessage);
			if (!sw) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().body(null);
		}
	}

}

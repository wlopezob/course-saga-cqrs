package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.rest;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.producer.PedidoProducer;

@RestController
@RequestMapping("/v1/pedidos/producer")
public class PedidoController{

	private final PedidoProducer pedidoProducer;
	
	private Logger logger = Logger.getLogger(PedidoController.class.getName());
		
	public PedidoController(PedidoProducer pedidoProducer) {

		this.pedidoProducer = pedidoProducer;
	}
	
	@GetMapping
	public ResponseEntity<?> messageBody(){
		
		PedidoResumenMessage pedidoResumenMessage = new PedidoResumenMessage();
		pedidoResumenMessage.setId(1L);
		pedidoResumenMessage.setGlosa("Pedido de equipos de cómputo");
		pedidoResumenMessage.setFechaRegistro(LocalDate.now().toString());
		pedidoResumenMessage.setTotal(10_000.00);
		pedidoResumenMessage.setCliente("20544987304 -  Comercial Hermanos Casa S.A.");
		
		return ResponseEntity.ok(pedidoResumenMessage);
	}

		

	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody PedidoResumenMessage pedidoResumenMessage){
		try {
			
			Boolean sw= pedidoProducer.sendMessage(pedidoResumenMessage);
			if (!sw) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(null);
		}
	}

}

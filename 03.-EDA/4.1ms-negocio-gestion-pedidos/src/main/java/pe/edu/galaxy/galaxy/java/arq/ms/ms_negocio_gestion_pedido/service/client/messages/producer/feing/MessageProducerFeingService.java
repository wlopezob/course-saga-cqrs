package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.messages.producer.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.messages.producer.PedidoResumenMessage;

@FeignClient(value = "ms-integracion-message-producer",url = "${ms-integracion-message-producer.url}")
public interface MessageProducerFeingService {


	@PostMapping
	ResponseEntity<Void> save(@RequestBody PedidoResumenMessage pedidoResumenMessage);
	
	
}

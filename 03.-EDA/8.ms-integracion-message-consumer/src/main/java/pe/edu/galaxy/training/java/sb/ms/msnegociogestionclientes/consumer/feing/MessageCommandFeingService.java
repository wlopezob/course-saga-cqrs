package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.consumer.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.message.PedidoResumenMessage;


@FeignClient(value = "ms-integracion-message-command",url = "${ms-integracion-message-command.url}")
public interface MessageCommandFeingService {

	@PostMapping
	ResponseEntity<Void> save(@RequestBody PedidoResumenMessage pedidoResumenMessage);
	
}

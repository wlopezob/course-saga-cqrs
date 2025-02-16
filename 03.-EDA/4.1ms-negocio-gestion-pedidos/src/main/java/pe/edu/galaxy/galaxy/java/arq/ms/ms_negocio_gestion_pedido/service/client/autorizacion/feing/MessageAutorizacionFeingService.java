package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.autorizacion.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.autorizacion.dto.PedidoAutorizacionMessage;


@FeignClient(value = "ms-autorizacion-saga-pedidos",url = "${ms-autorizacion-saga-pedidos.url}")
public interface MessageAutorizacionFeingService {


	@PostMapping
	ResponseEntity<Void> save(@RequestBody PedidoAutorizacionMessage pedidoAutorizacionMessage);
	
	
}

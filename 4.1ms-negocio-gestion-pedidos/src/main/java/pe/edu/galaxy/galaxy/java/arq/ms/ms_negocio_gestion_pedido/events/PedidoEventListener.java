package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events;

import java.io.IOException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.autorizacion.dto.PedidoAutorizacionMessage;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.autorizacion.feing.MessageAutorizacionFeingService;
//import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.feing.ClienteFeingServiceClient;
//import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.cliente.rest.template.ClienteDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.messages.producer.PedidoResumenMessage;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.service.client.messages.producer.feing.MessageProducerFeingService;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoEventListener {

	private final MessageProducerFeingService messageProducerFeingService;
	//private final ClienteFeingServiceClient clienteFeingServiceClient;
	private final MessageAutorizacionFeingService messageAutorizacionFeingService;

	@EventListener
	public void sendMessage(PedidoEventApplication<PedidoEventModel> event) throws IOException{
		 try {
			 PedidoEventModel pedidoEventModel = (PedidoEventModel) event.getSource();
				
				log.info("PedidoEventListener sendMessage ...", pedidoEventModel);
				
				this.enviarMessageCQRS(pedidoEventModel);
				
				this.enviarMessageSAGA(pedidoEventModel);

		} catch (Exception e) {
			log.error("PedidoEventListener -Error de sendMessage {}",e);
		}
	}

	private void enviarMessageCQRS(PedidoEventModel pedidoEventModel) {
		PedidoResumenMessage pedidoResumenMessage = new PedidoResumenMessage();
		pedidoResumenMessage.setIdPedido(pedidoEventModel.getId());
		pedidoResumenMessage.setGlosa(pedidoEventModel.getGlosa());
		pedidoResumenMessage.setFechaRegistro(pedidoEventModel.getFechaRegistro().toString());
		pedidoResumenMessage.setSubTotal(pedidoEventModel.getSubTotal());
		pedidoResumenMessage.setIgv(pedidoEventModel.getIgv());
		
		pedidoResumenMessage.setTotal(pedidoEventModel.getTotal());
		//ClienteDTO clienteDTO=clienteFeingServiceClient.findById(pedidoEventModel.getCliente().getId());
		String cliente = pedidoEventModel.getCliente().getRuc().concat(": ").concat(pedidoEventModel.getCliente().getRazonSocial());
		
		pedidoResumenMessage.setCliente(cliente);

		messageProducerFeingService.save(pedidoResumenMessage);
		
	}
	
	private void enviarMessageSAGA(PedidoEventModel pedidoEventModel) {

		PedidoAutorizacionMessage pedidoAutorizacionMessage = new PedidoAutorizacionMessage();
		pedidoAutorizacionMessage.setIdPedido(pedidoEventModel.getId());
		pedidoAutorizacionMessage.setFechaRegistro(pedidoEventModel.getFechaRegistro().toString());
		
		pedidoAutorizacionMessage.setTotal(pedidoEventModel.getTotal());
		
		pedidoAutorizacionMessage.setIdCliente(pedidoEventModel.getCliente().getId());

		messageAutorizacionFeingService.save(pedidoAutorizacionMessage);

	}


}

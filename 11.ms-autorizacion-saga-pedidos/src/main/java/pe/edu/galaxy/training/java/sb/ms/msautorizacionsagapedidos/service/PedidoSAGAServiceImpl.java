package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.service;

import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.message.PedidoAutorizacionMessage;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.producer.PedidoAutorizacionProducer;

@Service
public class PedidoSAGAServiceImpl implements PedidoSAGAService {
	
	
	private final PedidoAutorizacionProducer pedidoProducer;
	
	public PedidoSAGAServiceImpl(PedidoAutorizacionProducer pedidoProducer) {
		this.pedidoProducer = pedidoProducer;
	}



	@Override
	public Boolean sendMessage(PedidoAutorizacionMessage pedidoAutorizacionMessage) throws PedidoSAGAServiceException{
		try {
			return pedidoProducer.sendMessage(pedidoAutorizacionMessage);
		} catch (Exception e) {
			throw new PedidoSAGAServiceException(e);
		}
		
	}

}

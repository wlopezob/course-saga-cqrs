package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.aprobacion;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoRangoEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoSituacionEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.message.PedidoAutorizacionMessage;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.Manual.PedidoEvaluacionManualProducer;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.Manual.ProducerException;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.core.producer.automatica.PedidoEvaluacionAutomaticaProducer;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.model.PedidoRangoAprobacion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.repository.PedidoRangoAprobacionRedisRepository;

@Slf4j
@Service
public class PedidoAprobacionImpl implements PedidoAprobacion {

	private final PedidoEvaluacionAutomaticaProducer pedidoEvaluacionAutomaticaProducer;
	
	private final PedidoEvaluacionManualProducer pedidoEvaluacionManualProducer;
	
	private List<PedidoRangoAprobacion> lstPedidoRangoAprobacion;

	public PedidoAprobacionImpl(PedidoRangoAprobacionRedisRepository pedidoRangoAprobacionRedisRepository,
			PedidoEvaluacionManualProducer pedidoEvaluacionManualProducer,
			PedidoEvaluacionAutomaticaProducer pedidoEvaluacionAutomaticaProducer) {
		this.lstPedidoRangoAprobacion = pedidoRangoAprobacionRedisRepository.findAll();
		this.pedidoEvaluacionAutomaticaProducer = pedidoEvaluacionAutomaticaProducer;
		this.pedidoEvaluacionManualProducer=pedidoEvaluacionManualProducer;
	}

	@Override
	public boolean aprobar(PedidoAutorizacionMessage pedidoAutorizacionMessage) {
		
		this.lstPedidoRangoAprobacion.forEach(System.out::println);
		
		try {
			
			// Fecha de entrega
			
			if (pedidoAutorizacionMessage.getTotal() < getRango(PedidoRangoEnum.BAJO).getValor()) {
				
				pedidoAutorizacionMessage.setSituacion(PedidoSituacionEnum.APROBADO);
				
				pedidoEvaluacionAutomaticaProducer.sendMessage(pedidoAutorizacionMessage);
				
				return true;
			} else {
				
				if (pedidoAutorizacionMessage.getTotal() < getRango(PedidoRangoEnum.MEDIO).getValor()) {
					pedidoAutorizacionMessage.setNivelAprobacion(PedidoRangoEnum.MEDIO);
				}else {
					pedidoAutorizacionMessage.setNivelAprobacion(PedidoRangoEnum.ALTO);
				}
				
				pedidoAutorizacionMessage.setSituacion(PedidoSituacionEnum.PENDIENTE);
				
				pedidoEvaluacionManualProducer.sendMessage(pedidoAutorizacionMessage);
				
			}
			return false;
		} catch (ProducerException e) {
			log.error(e.getMessage());
			return false;
		}

	}

	private PedidoRangoAprobacion getRango(PedidoRangoEnum rango) {
		return lstPedidoRangoAprobacion.stream().filter(r -> {
			return rango.compareTo(rango) == 0;
		}).findFirst().orElse(null);
	}

}

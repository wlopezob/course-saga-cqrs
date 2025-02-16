package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoRangoEnum;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.model.PedidoRangoAprobacion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.repository.PedidoRangoAprobacionRedisRepository;

@Component
public class ComponentInit implements ApplicationRunner{
	
	@Autowired
	private PedidoRangoAprobacionRedisRepository pedidoRangoAprobacionRedisRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Pregarga en redis
		
		List<PedidoRangoAprobacion> data= new ArrayList<>();
		
		data.add(PedidoRangoAprobacion.builder().id(1).valor(500.00).rango(PedidoRangoEnum.BAJO).build());
		data.add(PedidoRangoAprobacion.builder().id(2).valor(1_000.00).rango(PedidoRangoEnum.MEDIO).build());
		data.add(PedidoRangoAprobacion.builder().id(3).valor(5_000.00).rango(PedidoRangoEnum.ALTO).build());
		
		data.forEach(e->pedidoRangoAprobacionRedisRepository.save(e));
	
		
	}

}

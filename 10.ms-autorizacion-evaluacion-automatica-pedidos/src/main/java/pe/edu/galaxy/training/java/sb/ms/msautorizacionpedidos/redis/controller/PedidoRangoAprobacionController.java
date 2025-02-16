package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import lombok.Data;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.model.PedidoRangoAprobacion;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.repository.PedidoRangoAprobacionRedisRepository;

@Data
@RestController
@RequestMapping("/v1/pedido-rango-aprobacion")
public class PedidoRangoAprobacionController {


	private final PedidoRangoAprobacionRedisRepository pedidoRangoAprobacionRedisRepository;
	
	public PedidoRangoAprobacionController(PedidoRangoAprobacionRedisRepository pedidoRangoAprobacionRedisRepository) {
		this.pedidoRangoAprobacionRedisRepository = pedidoRangoAprobacionRedisRepository;
	}


	@PostMapping
	public PedidoRangoAprobacion save(@RequestBody PedidoRangoAprobacion pedidoRangoAprobacion) {
		pedidoRangoAprobacionRedisRepository.save(pedidoRangoAprobacion);
		return pedidoRangoAprobacion;
	}

	@GetMapping
	public List<?> list() {
		return pedidoRangoAprobacionRedisRepository.findAll();
	}

	@GetMapping("/{id}")
	public PedidoRangoAprobacion getTaller(@PathVariable Integer id) {
		return pedidoRangoAprobacionRedisRepository.findById(id);
	}

	@PutMapping
	public PedidoRangoAprobacion update(@RequestBody PedidoRangoAprobacion pedidoRangoAprobacion) {
		pedidoRangoAprobacionRedisRepository.update(pedidoRangoAprobacion);
		return pedidoRangoAprobacion;
	}

	@DeleteMapping("/{id}")
	public String deleteTaller(@PathVariable String id) {
		pedidoRangoAprobacionRedisRepository.delete(id);
		return id;
	}

	
}

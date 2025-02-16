package pe.edu.galaxy.java.spring.boot.redis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import lombok.Data;
import pe.edu.galaxy.java.spring.boot.redis.model.Taller;
import pe.edu.galaxy.java.spring.boot.redis.repository.TallerRedisRepository;

@Data
@RestController
@RequestMapping("/talleres")
public class TallerController {

	@Autowired
	private TallerRedisRepository tallerRedisRepository;

	@PostMapping
	public Taller save(@RequestBody Taller Taller) {
		tallerRedisRepository.save(Taller);
		return Taller;
	}

	@GetMapping
	public List<?> list() {
		return tallerRedisRepository.findAll();
	}

	@GetMapping("/{id}")
	public Taller getTaller(@PathVariable String id) {
		return tallerRedisRepository.findById(id);
	}

	@PutMapping
	public Taller update(@RequestBody Taller Taller) {
		tallerRedisRepository.update(Taller);
		return Taller;
	}

	@DeleteMapping("/{id}")
	public String deleteTaller(@PathVariable String id) {
		tallerRedisRepository.delete(id);
		return id;
	}

	@GetMapping("/test")
	public Taller test() {
		return Taller.builder()
				.id("1")
				.nombre("Demo Redis")
				.descripcion("Redis con Spring Boot")
				.duracion(2)
				.build();
	}
	
}

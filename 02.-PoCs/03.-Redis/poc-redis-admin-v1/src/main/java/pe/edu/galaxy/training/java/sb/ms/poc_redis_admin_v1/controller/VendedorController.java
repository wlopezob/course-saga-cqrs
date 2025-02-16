package pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.entity.Vendedor;
import pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.repository.VededorRepository;

@RestController
@RequestMapping("/v1/vendedor/admin")
public class VendedorController {

	private final VededorRepository vededorRepository;

	public VendedorController(VededorRepository vededorRepository) {
		this.vededorRepository = vededorRepository;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Vendedor vendedor) {
		try {

			vededorRepository.save(vendedor);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> ret = new HashMap<>();
			ret.put("error", "Error interno");
			return ResponseEntity.internalServerError().body(ret);
		}
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {

			List<Vendedor> lstVendedor = new ArrayList<>();
			vededorRepository.findAll().forEach(lstVendedor::add);
			if (lstVendedor.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstVendedor);

		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> ret = new HashMap<>();
			ret.put("error", "Error interno");
			return ResponseEntity.internalServerError().body(ret);
		}
	}
}

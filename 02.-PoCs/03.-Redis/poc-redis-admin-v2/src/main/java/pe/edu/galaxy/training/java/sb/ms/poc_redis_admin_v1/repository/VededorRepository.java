package pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.entity.Vendedor;

@Repository
public interface VededorRepository extends CrudRepository<Vendedor, String> {
	
}
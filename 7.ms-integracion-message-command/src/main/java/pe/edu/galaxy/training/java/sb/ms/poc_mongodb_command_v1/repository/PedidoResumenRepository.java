package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;

@Repository
public interface PedidoResumenRepository extends MongoRepository<PedidoResumenDocument, String>{
	
	/*
	List<PedidoResumenDocument> findByEstado(String estado);
	Optional<PedidoResumenDocument> findByTallerId(Long tallerId);
	*/

}

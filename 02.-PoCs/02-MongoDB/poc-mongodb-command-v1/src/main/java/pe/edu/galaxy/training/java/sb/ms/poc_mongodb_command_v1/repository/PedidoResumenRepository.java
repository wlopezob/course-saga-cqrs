package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document.PedidoResumenDocument;

@Repository
public interface PedidoResumenRepository extends MongoRepository<PedidoResumenDocument, String>{
	
	

}

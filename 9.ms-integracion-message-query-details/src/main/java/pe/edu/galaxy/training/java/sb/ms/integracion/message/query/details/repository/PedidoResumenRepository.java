package pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.document.PedidoResumenDocument;

@Repository
public interface PedidoResumenRepository extends MongoRepository<PedidoResumenDocument, String>{	
	
	@Query(" { glosa: { $regex : '(?i)?0'} }")
	List<PedidoResumenDocument> findByPedidoGlosaLike(String glosa);
}

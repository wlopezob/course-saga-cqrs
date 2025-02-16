package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoItemEntity;


@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItemEntity, Long>{
	
	@Query("select p from PedidoItemEntity p where p.pedido.id=:idPedido and p.estado='1'")
	List<PedidoItemEntity> findByIdPedido(@Param("idPedido") Long idPedido);

}

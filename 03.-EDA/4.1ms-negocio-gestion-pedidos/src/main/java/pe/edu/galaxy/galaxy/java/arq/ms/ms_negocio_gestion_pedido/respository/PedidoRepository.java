package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	@Modifying
	@Query(value = "update tbl_pedido set situacion=:situacion where pedido_id=:id",nativeQuery = true)
	void updateSituacion(@Param("situacion") Integer situacion, @Param("id") Long id);  
}

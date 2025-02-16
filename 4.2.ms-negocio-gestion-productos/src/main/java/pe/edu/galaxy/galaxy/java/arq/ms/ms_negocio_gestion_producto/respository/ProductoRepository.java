package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_producto.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_producto.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {


	//JPQL
	
	@Query("Select p from ProductoEntity p where p.estado='1'")
	List<ProductoEntity> findAllCustom();
	
	@Query("Select p from ProductoEntity p where upper(p.nombre) like upper(:nombre) and p.estado='1'")
	List<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);

	//SQL
	
	@Modifying
	@Query(nativeQuery = true, value = "update tbl_producto set estado='0' where producto_id=:id")
	void deleteCustom(@Param("id") Long id);
	

	@Query("Select p from ProductoEntity p where id in (:ids)")
	List<ProductoEntity> findByIds(@Param("ids") List<Long> ids);

	@Modifying
	@Query(value = "update tbl_producto set stock=(stock+:stock) where producto_id=:id",nativeQuery = true)
	void updateStock(@Param("stock") Integer stock, @Param("id") Long id);  

	@Modifying
	@Query(value = "update tbl_producto set reserva=(reserva+:reserva) where producto_id=:id",nativeQuery = true)
	void updateReserva(@Param("reserva") Integer reserva, @Param("id") Long id);  
}

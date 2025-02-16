package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.repository;

import java.util.List;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.model.PedidoRangoAprobacion;

@Slf4j
@Repository
@SuppressWarnings("rawtypes")
public class PedidoRangoAprobacionRedisRepository {

	public static final String PEDIRO_RA_KEY = "PED_RA";

	private HashOperations<String, Integer, PedidoRangoAprobacion> hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	@SuppressWarnings("unchecked")
	public PedidoRangoAprobacionRedisRepository(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}
	
	public void save(PedidoRangoAprobacion pra) {
		log.info("save...");
		hashOperations.put(PEDIRO_RA_KEY, pra.getId(), pra);
	}


	public List<PedidoRangoAprobacion> findAll() {
		log.info("findAll...");
		return hashOperations.values(PEDIRO_RA_KEY);
	}


	public PedidoRangoAprobacion findById(Integer id) {
		log.info("findById...");
		return (PedidoRangoAprobacion) hashOperations.get(PEDIRO_RA_KEY, id);
	}

	
	public void update(PedidoRangoAprobacion pra) {
		log.info("update...");
		save(pra);
	}

	public void delete(String id) {
		log.info("delete...");
		hashOperations.delete(PEDIRO_RA_KEY, id);
	}

}

package pe.edu.galaxy.java.spring.boot.redis.repository;

import java.util.List;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.java.spring.boot.redis.model.Taller;

@Slf4j
@Repository
@SuppressWarnings("rawtypes")
public class TallerRedisRepository {

	public static final String TALLER_KEY = "TALLER";

	private HashOperations<String, String, Taller> hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	@SuppressWarnings("unchecked")
	public TallerRedisRepository(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}
	
	public void save(Taller taller) {
		log.info("save...{}",taller);
		hashOperations.put(TALLER_KEY, taller.getId(), taller);
	}


	public List<Taller> findAll() {
		log.info("findAll...");
		return hashOperations.values(TALLER_KEY);
	}


	public Taller findById(String id) {
		log.info("findById...{}",id);
		return (Taller) hashOperations.get(TALLER_KEY, id);
	}

	
	public void update(Taller taller) {
		log.info("update...{}",taller);
		save(taller);
	}

	public void delete(String id) {
		log.info("delete...{}",id);
		hashOperations.delete(TALLER_KEY, id);
	}

}

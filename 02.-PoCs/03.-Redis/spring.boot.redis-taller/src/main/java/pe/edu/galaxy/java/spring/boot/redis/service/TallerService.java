package pe.edu.galaxy.java.spring.boot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.java.spring.boot.redis.repository.TallerRedisRepository;

@Service
public class TallerService {

	@Autowired
	private TallerRedisRepository tallerRepository;
	
}

package pe.edu.galaxy.java.spring.boot.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ComponentInit implements ApplicationRunner{
	
	@Autowired
	//private TipoTallerRepository tipoTallerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Pregarga en redis
		
		
	}

}

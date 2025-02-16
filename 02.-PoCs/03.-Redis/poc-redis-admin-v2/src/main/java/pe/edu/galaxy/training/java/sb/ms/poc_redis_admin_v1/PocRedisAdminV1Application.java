package pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication/*(exclude = { RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class })*/
public class PocRedisAdminV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PocRedisAdminV1Application.class, args);
	}

}

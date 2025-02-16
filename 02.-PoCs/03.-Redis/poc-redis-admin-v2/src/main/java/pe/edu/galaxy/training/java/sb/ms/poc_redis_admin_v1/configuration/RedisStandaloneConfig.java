package pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

//@Configuration
//@PropertySource("application.yml")
public class RedisStandaloneConfig {

	@Autowired
	private Environment env;

	@Bean
	public LettuceConnectionFactory connectionFactory() {

		RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
		redisConf.setHostName(env.getProperty("spring.data.redis.host"));
		redisConf.setPort(Integer.parseInt(env.getProperty("spring.data.redis.port")));
		// redisConf.setPassword(RedisPassword.of(env.getProperty("spring.data.redis.password")));
		return new LettuceConnectionFactory(redisConf);
	}
}
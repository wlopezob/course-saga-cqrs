package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class JedisConfig {
	
	@Value("${spring.data.redis.host}")
	private String redisHost;

	@Value("${spring.data.redis.port}")
	private Integer redisPort;
	

	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	
	@Primary
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;

		/*
		 * RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		 * redisTemplate.setConnectionFactory(jedisConnectionFactory());
		 * FastJsonRedisSerializer fastJsonRedisSerializer = new
		 * FastJsonRedisSerializer(Object.class);
		 * redisTemplate.setDefaultSerializer(fastJsonRedisSerializer); return
		 * redisTemplate;
		 */
	}
}

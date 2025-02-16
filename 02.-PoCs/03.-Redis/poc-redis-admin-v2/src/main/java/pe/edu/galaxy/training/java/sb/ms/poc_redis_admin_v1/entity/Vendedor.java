package pe.edu.galaxy.training.java.sb.ms.poc_redis_admin_v1.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("vendedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vendedor implements Serializable{

	private static final long serialVersionUID = 2390838097705301114L;
	private Long id;
	private String nombreCompleto;
	private String cargo;

}

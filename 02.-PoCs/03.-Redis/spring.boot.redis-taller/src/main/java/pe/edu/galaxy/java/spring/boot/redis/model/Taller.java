package pe.edu.galaxy.java.spring.boot.redis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonRootName(value = "taller")
@JsonInclude(Include.NON_NULL)
@RedisHash
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Taller implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nombre;
	
	private String descripcion;
	
	private int duracion;	

}

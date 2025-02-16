package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.redis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons.PedidoRangoEnum;


@JsonRootName(value = "pedido-rango-aprobacion")
@JsonInclude(Include.NON_NULL)
@Builder
@RedisHash("pedido-rango-aprobacion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoRangoAprobacion implements Serializable{

	private static final long serialVersionUID = 2390838097705301114L;
	private Integer id;
	private Double valor;
	private PedidoRangoEnum rango;

}

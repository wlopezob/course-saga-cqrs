package pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value =  "pedido-resumen")
public class PedidoResumenDocument {

	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	@Indexed
	@Field("idPedido")
	private Long idPedido;
	
	@Field("glosa")
	private String glosa;

	@Field("fechaRegistro")
	private String fechaRegistro;
	
	@Field("total")
	private Double total;
	
	@Field("cliente")
	private String cliente;
}


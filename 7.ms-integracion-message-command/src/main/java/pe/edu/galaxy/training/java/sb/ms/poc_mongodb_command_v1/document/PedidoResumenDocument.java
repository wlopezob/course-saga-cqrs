package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value =  "pedido-resumen")
public class PedidoResumenDocument {

	@MongoId(FieldType.OBJECT_ID)
	private String _id;

	@Field("idPedido")
	private Long idPedido;
	
	@Field("glosa")
	private String glosa;

	@Field("fechaRegistro")
	private String fechaRegistro;
	
	
	@Field("fechaIntegracion")
	private String fechaIntegracion;
	
	@Field("total")
	private Double total;
	
	@Field("cliente")
	private String cliente;
}


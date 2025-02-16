package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity(name ="ClienteEntity" )
@Table(name =  "tbl_cliente")
public class ClienteEntity {

	@Id
	@Column(name = "cliente_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
	// @SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqCliente")
	private Long id;
	
	@Column(name = "razon_social", nullable = false, length =260 )
	private String razonSocial;
	
	@Column(name = "ruc", nullable = false, length =11 )
	private String ruc;

	@Column(name = "direccion", nullable = false, length =400 )
	private String direccion;

	@Column(name = "telefono", nullable = false, length =20 )
	private String telefono;

	@Column(name = "correo", nullable = false, length =60 )
	private String correo;

	@Column(name = "estado", nullable = false, length =1 )
	private String estado="1";
	
}



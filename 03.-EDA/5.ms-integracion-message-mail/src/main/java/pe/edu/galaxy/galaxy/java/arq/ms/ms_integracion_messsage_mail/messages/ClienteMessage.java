package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages;

import lombok.Data;

@Data
public class ClienteMessage{

	private Long id;
	
	private String razonSocial;
	
	private String ruc;

	private String direccion;

	private String telefono;

	private String correo;

	
}



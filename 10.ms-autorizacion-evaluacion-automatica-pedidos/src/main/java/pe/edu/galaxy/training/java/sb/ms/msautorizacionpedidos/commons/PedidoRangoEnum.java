package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos.commons;

import java.util.Arrays;

public enum PedidoRangoEnum {
	
	BAJO(1, "Bajo-Automático"), 
	MEDIO(2, "Medio-Supervisor"),
	ALTO(3, "Alto-Gerente");
	
	private Integer valor;

	private String descripcion;

	private PedidoRangoEnum(Integer valor, String descripcion) {
		this.valor = valor;
		this.descripcion = descripcion;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PedidoRangoEnum valueOfDescripcion(String descripcion) {
		return valueOf(descripcion);
	}
	
	// Converts
	public static PedidoRangoEnum getByValor(Integer valor) {
		return (Arrays.stream(values()).filter(p -> p.valor == valor).findFirst())
				.orElseThrow(() -> new RuntimeException(String.format("Valor %s, no válido", valor)));
	}

}

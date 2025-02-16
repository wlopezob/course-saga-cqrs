package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.commons;

import java.util.Arrays;

public enum PedidoSituacionEnum {
	
	REGISTRADO(0, "Registrado"),
	EVALUACION(1,"En evaluación"),
	PENDIENTE(2, "Pendiente de aprobación"),
	APROBADO(3, "Aprobado"),
	RECHAZADO(4, "Rechazado");

	private Integer valor;

	private String descripcion;

	private PedidoSituacionEnum(Integer valor, String descripcion) {
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

	public PedidoSituacionEnum valueOfDescripcion(String descripcion) {
		return valueOf(descripcion);
	}
	
	// Converts
	public static PedidoSituacionEnum getByValor(Integer valor) {
		return (Arrays.stream(values()).filter(p -> p.valor == valor).findFirst())
				.orElseThrow(() -> new RuntimeException(String.format("Valor %s, no válido", valor)));
	}

}

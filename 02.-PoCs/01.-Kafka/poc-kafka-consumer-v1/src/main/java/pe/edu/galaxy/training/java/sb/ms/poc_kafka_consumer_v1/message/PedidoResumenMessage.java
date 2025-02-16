package pe.edu.galaxy.training.java.sb.ms.poc_kafka_consumer_v1.message;

import java.io.Serializable;

public class PedidoResumenMessage implements Serializable{

	private static final long serialVersionUID = -8970025549640140018L;

	private Long id;
			
	private String glosa;

	private String fechaRegistro;
	
	private Double total;
	
	private String cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "PedidoResumenMessage [id=" + id + ", glosa=" + glosa + ", fechaRegistro=" + fechaRegistro + ", total="
				+ total + ", cliente=" + cliente + "]";
	}

	
}


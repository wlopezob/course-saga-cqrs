package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.events;

import org.springframework.context.ApplicationEvent;

public class PedidoEventApplication<T> extends ApplicationEvent {
	
	private static final long serialVersionUID = 7495258689624069110L;

	public PedidoEventApplication(T source) {
		super(source);
	
	}

}

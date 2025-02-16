package pe.edu.galaxy.training.java.sb.ms.poc_kafka_consumer_v1.consumer;

import pe.edu.galaxy.training.java.sb.ms.poc_kafka_consumer_v1.message.PedidoResumenMessage;

public interface PedidoConsumer {

	void readMessage(PedidoResumenMessage  pedidoResumenMessage);
	
}

package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.messages.ClienteMessage;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	public ProducerFactory<String, ClienteMessage> producerFactory() {
		
		Map<String, Object> config = new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.ACKS_CONFIG, "all");

		return new DefaultKafkaProducerFactory<>(config);

	}

	@Bean
	KafkaTemplate<String, ClienteMessage> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
}

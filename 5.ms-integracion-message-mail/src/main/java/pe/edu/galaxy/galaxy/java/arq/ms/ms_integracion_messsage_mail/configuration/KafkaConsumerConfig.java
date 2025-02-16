package pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class KafkaConsumerConfig {
	
	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${kafka.group.group-clientes-id}")
	private String groupId;

	public ConsumerFactory<String, ClienteMessage> clienteConsumerFactory() {
		
		log.info("bootstrapServers {}",bootstrapServers);
		
		log.info("groupId {}",groupId);
		
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
		
		config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, ErrorHandlingDeserializer.class);
		config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, ErrorHandlingDeserializer.class);
		
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages");
		config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "pe.edu.galaxy.galaxy.java.arq.ms.ms_integracion_messsage_mail.messages.ClienteMessage");
		
		config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		
		return new DefaultKafkaConsumerFactory<>(config);

	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<String, ClienteMessage> clientekafkaListenerContainerFactory() {
		
		log.info("pedidoKafkaListenerContainerFactory...");
		
		ConcurrentKafkaListenerContainerFactory<String, ClienteMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(clienteConsumerFactory());
		
		return factory;
	}	
	
}
package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_pedido.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalConfig {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	WebProperties.Resources resources() {
		return new WebProperties.Resources();
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Agregar Provider & Converters

}
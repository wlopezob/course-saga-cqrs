package pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PocMongodbQueyDetailsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PocMongodbQueyDetailsV1Application.class, args);
	}

}

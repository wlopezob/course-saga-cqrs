package pe.edu.galaxy.training.java.sb.ms.poc_mongodb_command_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PocMongodbCommandV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PocMongodbCommandV1Application.class, args);
	}

}

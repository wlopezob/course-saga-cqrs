package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionPedidosApplication.class, args);
	}

}

package pe.edu.galaxy.training.java.sb.ms.msautorizacionpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionPedidosApplication.class, args);
	}

}

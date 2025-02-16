package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionClienteApplication.class, args);
	}

}

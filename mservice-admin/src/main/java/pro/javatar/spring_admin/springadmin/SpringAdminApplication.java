package pro.javatar.spring_admin.springadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class SpringAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdminApplication.class, args);
	}
}

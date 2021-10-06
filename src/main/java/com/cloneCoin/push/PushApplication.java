package com.cloneCoin.push;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Push Server", version = "1.0", description = "Documentation APIS v1.0"))
public class PushApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushApplication.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}

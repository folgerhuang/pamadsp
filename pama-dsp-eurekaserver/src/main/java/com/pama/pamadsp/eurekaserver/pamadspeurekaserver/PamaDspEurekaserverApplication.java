package com.pama.pamadsp.eurekaserver.pamadspeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PamaDspEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PamaDspEurekaserverApplication.class, args);
	}
}

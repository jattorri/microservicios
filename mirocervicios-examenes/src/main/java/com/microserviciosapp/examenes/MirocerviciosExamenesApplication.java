package com.microserviciosapp.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.microservicios.commons.examenes.models.entity"})
public class MirocerviciosExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MirocerviciosExamenesApplication.class, args);
	}

}

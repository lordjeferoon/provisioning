package com.hacom.ussdmxaprovisionamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hacom")
public class UssdMxAprovisionamientoApplication {

	public static void main(String[] args) {
        SpringApplication.run(UssdMxAprovisionamientoApplication.class, args);
	}
	
}

package com.hacom.ussdmxaprovisionamiento.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ComponentScan(basePackages = "com.hacom")
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "app")
public class AppConfig {
	
	private String mongodbDatabase;
	private String mongodbUri;

}

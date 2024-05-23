package com.hacom.ussdmxaprovisionamiento.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.hacom.ussdmxaprovisionamiento")
public class MongoConfig {

}

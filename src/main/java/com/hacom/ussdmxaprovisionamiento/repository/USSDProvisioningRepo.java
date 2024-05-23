package com.hacom.ussdmxaprovisionamiento.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.stereotype.Repository;

import com.hacom.ussdmxaprovisionamiento.model.USSDProvisioning;

import reactor.core.publisher.Flux;

@Repository
public interface USSDProvisioningRepo extends ReactiveMongoRepository<USSDProvisioning, String> {
    Flux<USSDProvisioning> findAllByStatus(boolean status);
}

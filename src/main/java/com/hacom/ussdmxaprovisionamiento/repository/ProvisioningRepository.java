package com.hacom.ussdmxaprovisionamiento.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.stereotype.Repository;

import com.hacom.ussdmxaprovisionamiento.model.Provisioning;

import reactor.core.publisher.Flux;

@Repository
public interface ProvisioningRepository extends ReactiveMongoRepository<Provisioning, String> {
    Flux<Provisioning> findAllByStatus(boolean status);
}

package com.hacom.ussdmxaprovisionamiento.service;

import com.hacom.ussdmxaprovisionamiento.model.Provisioning;
import com.hacom.ussdmxaprovisionamiento.repository.ProvisioningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProvisioningService {

    @Autowired
    private ProvisioningRepository repository;

    public Mono<Provisioning> saveProvisioning(Provisioning provisioning) {
        return repository.save(provisioning)
                .doOnSuccess(savedProvisioning -> {
                    System.out.println("Éxito");
                })
                .doOnError(error -> {
                    System.out.println("Error: " + error.getMessage());
                });
    }
    
    public Mono<Provisioning> updateStatusToFalse(String imsi) {
        return repository.findByImsi(imsi)
                .flatMap(provisioning -> {
                    provisioning.setStatus(false);
                    return repository.save(provisioning);
                })
                .doOnSuccess(updatedProvisioning -> {
                    System.out.println("Estado actualizado a false para: " + updatedProvisioning);
                })
                .doOnError(error -> {
                    System.out.println("Error al actualizar estado: " + error.getMessage());
                });
    }
}

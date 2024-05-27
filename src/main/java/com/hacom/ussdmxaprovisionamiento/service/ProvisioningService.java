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
        return repository.save(provisioning);
    }

}

package com.hacom.ussdmxaprovisionamiento.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tt_ussd_provisioning")
public class USSDProvisioning {
	
    @Id
    private String id;

    private String msisdn;
    private String imsi;
    private String subscription;
    private String language;
    private boolean status;
    
}

package com.hacom.ussdmxaprovisionamiento.controller;

import com.hacom.ussdmxaprovisionamiento.model.Provisioning;
import com.hacom.ussdmxaprovisionamiento.service.ProvisioningService;
//import com.hacom.ussdmxaprovisionamiento.xml.MethodCall;
import com.hacom.ussdmxaprovisionamiento.xml.MethodCallRequest;
import com.hacom.ussdmxaprovisionamiento.xml.MethodCallResponse;

//import com.hacom.ussdmxaprovisionamiento.xml.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProvisioningEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/provisioning";

    @Autowired
    private ProvisioningService provisioningService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MethodCallRequest")
    @ResponsePayload
    public MethodCallResponse saveProvisioning(@RequestPayload MethodCallRequest methodCall) {
    	MethodCallResponse response = new MethodCallResponse();
    	
    	if(methodCall.getMethodName().equals("provisioning.createbyImsi")) {
            Provisioning provisioning = new Provisioning();
            provisioning.setImsi(methodCall.getParams().getParam().get(0).getValue().getString());
            MethodCallRequest.Params.Param.Value.Struct struct = methodCall.getParams().getParam().get(0).getValue().getStruct();
            for (MethodCallRequest.Params.Param.Value.Struct.Member member : struct.getMember()) {
                if (member.getName().equals("msisdn")) {
                    provisioning.setMsisdn(member.getVariable().getString());
                } else if (member.getName().equals("subscription")) {
                    provisioning.setSubscription(member.getVariable().getString());
                } else if (member.getName().equals("language")) {
                    provisioning.setLanguage(member.getVariable().getString());
                }
            }

            provisioningService.saveProvisioning(provisioning)
                .doOnSuccess(savedProvisioning -> {
                    response.setMessage("SUCCESS");
                    response.setResult("Provisioning saved successfully");
                    System.out.println("Provisioning saved successfully: " + savedProvisioning);
                })
                .doOnError(error -> {
                    response.setMessage("ERROR");
                    response.setResult("Provisioning failed: " + error.getMessage());
                    System.out.println("Provisioning save failed: " + error.getMessage());
                })
                .block();
    	}else {
    		if(methodCall.getMethodName().equals("provisioning.deletebyImsi")) {

    			provisioningService.updateStatusToFalse(methodCall.getParams().getParam().get(0).getValue().getString()) //IMSI
                .doOnSuccess(updatedProvisioning -> {
                    response.setMessage("SUCCESS");
                    response.setResult("Status updated to false for IMSI: " + updatedProvisioning.getImsi());
                })
                .doOnError(error -> {
                    response.setMessage("ERROR");
                    response.setResult("Failed to update status: " + error.getMessage());
                })
                .block(); // Bloquea la ejecución hasta que se complete

            return response;
    		}else {
    			response.setMessage("NOT FOUND");
                response.setResult("Método no encontrado");
    		}
    	}
    	
    	return response;
    }
}
package com.hacom.ussdmxaprovisionamiento.controller;

import com.hacom.ussdmxaprovisionamiento.model.Provisioning;
import com.hacom.ussdmxaprovisionamiento.service.ProvisioningService;
import com.hacom.ussdmxaprovisionamiento.xml.MethodCall;
import com.hacom.ussdmxaprovisionamiento.xml.Response;
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
    public Response saveProvisioning(@RequestPayload MethodCall methodCall) {
    	System.out.println("Entro");
        Provisioning provisioning = new Provisioning();
        provisioning.setImsi(methodCall.getParams().getParam().get(0).getValue().getString());
        MethodCall.Params.Param.Value.Struct struct = methodCall.getParams().getParam().get(0).getValue().getStruct();
        for (MethodCall.Params.Param.Value.Struct.Member member : struct.getMember()) {
            if (member.getName().equals("msisdn")) {
                provisioning.setMsisdn(member.getValue().getValue());
            } else if (member.getName().equals("subscription")) {
                provisioning.setSubscription(member.getValue().getValue());
            } else if (member.getName().equals("language")) {
                provisioning.setLanguage(member.getValue().getValue());
            }
        }

        provisioningService.saveProvisioning(provisioning);
        return new Response("SUCCESS", "Provisioning saved successfully");
    }
}

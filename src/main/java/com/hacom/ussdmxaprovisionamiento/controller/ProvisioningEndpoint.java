package com.hacom.ussdmxaprovisionamiento.controller;

import com.hacom.ussdmxaprovisionamiento.model.Provisioning;
import com.hacom.ussdmxaprovisionamiento.repository.ProvisioningRepository;
import com.hacom.ussdmxaprovisionamiento.service.ProvisioningService;
import com.hacom.ussdmxaprovisionamiento.xml.MethodCall;
import com.hacom.ussdmxaprovisionamiento.xml.Response;

import reactor.core.publisher.Mono;

//import com.hacom.ussdmxaprovisionamiento.service.USSDProvisioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.UUID;
import java.io.StringReader;

@Endpoint
public class ProvisioningEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.example.com/provisioning";
	
    @Autowired
    private ProvisioningService provisioningService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "methodCall")
    @ResponsePayload
    public Response saveProvisioning(@RequestPayload MethodCall methodCall) {
        Provisioning provisioning = new Provisioning();
        provisioning.setImsi(methodCall.getParams().getParam().get(0).getValue().getString());
        MethodCall.Params.Param.Value.Struct struct = methodCall.getParams().getParam().get(1).getValue().getStruct();
        for (MethodCall.Params.Param.Value.Struct.Member member : struct.getMember()) {
            switch (member.getName()) {
                case "msisdn":
                    provisioning.setMsisdn(member.getValue().getString());
                    break;
                case "subscription":
                    provisioning.setSubscription(member.getValue().getString());
                    break;
                case "language":
                    provisioning.setLanguage(member.getValue().getString());
                    break;
            }
        }
        provisioningService.saveProvisioning(provisioning).subscribe();
        return new Response("Success");
    }

}

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
    	MethodCallResponse.Params responseParams = new MethodCallResponse.Params();
        MethodCallResponse.Params.Param param = new MethodCallResponse.Params.Param();
        MethodCallResponse.Params.Param.Value value = new MethodCallResponse.Params.Param.Value();
    	
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
                    value.setBooleanValue(1);
                    param.setValue(value);
                    responseParams.getParam().add(param);
                    response.setParams(responseParams);
                    
                    System.out.println("Provisioning saved successfully: " + savedProvisioning);
                })
                .doOnError(error -> {
                	response.setFault(createFaultResponse("4", error.getMessage()));
                    //System.out.println("Provisioning save failed: " + error.getMessage());
                })
                .block();
    	}else {
    		if(methodCall.getMethodName().equals("provisioning.deletebyImsi")) {

    			provisioningService.updateStatusToFalse(methodCall.getParams().getParam().get(0).getValue().getString()) //IMSI
                .doOnSuccess(updatedProvisioning -> {
                	if(updatedProvisioning!= null) {
                		value.setBooleanValue(1);
                        param.setValue(value);
                        responseParams.getParam().add(param);
                        response.setParams(responseParams);
                	}else {
                		response.setFault(createFaultResponse("4", "No se realizó la eliminación. MSISDN no encontrado"));
                	}
                })
                .doOnError(error -> {
                	response.setFault(createFaultResponse("4", "Error deleting provisioning"));
                })
                .block(); // Bloquea la ejecución hasta que se complete

            return response;
    		}else {
    			if(methodCall.getMethodName().equals("provisioning.consultbyImsi")) {
    				provisioningService.findProvisioningByImsi(methodCall.getParams().getParam().get(0).getValue().getString())
    				.doOnSuccess(provisioning -> {
    					if(provisioning!= null) {
    						value.setBooleanValue(1);
                            
    					}else {
    						value.setBooleanValue(0);
    					}
    					param.setValue(value);
                        responseParams.getParam().add(param);
                        response.setParams(responseParams);
                    })
    				.doOnError(error -> {
    					response.setFault(createFaultResponse("4", "Error deleting provisioning"));
                    })
    				.block();
    			}else {
    				response.setFault(createFaultResponse("4", "Método no existente"));
    			}
    			
    		}
    	}
    	
    	return response;
    }
    
    private MethodCallResponse.Fault createFaultResponse(String faultCode, String faultString) {
        MethodCallResponse.Fault fault = new MethodCallResponse.Fault();
        MethodCallResponse.Fault.FaultValue value = new MethodCallResponse.Fault.FaultValue();
        MethodCallResponse.Fault.FaultValue.FaultStruct struct = new MethodCallResponse.Fault.FaultValue.FaultStruct();
        MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember faultCodeMember = new MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember();
        MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember faultStringMember = new MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember();
        
        faultCodeMember.setName("faultCode");
        MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue faultCodeValue = new MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue();
        faultCodeValue.setIntValue(Integer.parseInt(faultCode));
        faultCodeMember.setValue(faultCodeValue);

        faultStringMember.setName("faultString");
        MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue faultStringValue = new MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue();
        faultStringValue.setStringValue(faultString);
        faultStringMember.setValue(faultStringValue);

        struct.getMember().add(faultCodeMember);
        struct.getMember().add(faultStringMember);
        value.setStruct(struct);
        fault.setValue(value);

        return fault;
    }
}
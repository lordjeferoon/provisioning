
package com.hacom.ussdmxaprovisionamiento.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.provisioning package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.provisioning
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MethodCallRequest }
     * 
     */
    public MethodCallRequest createMethodCallRequest() {
        return new MethodCallRequest();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params }
     * 
     */
    public MethodCallRequest.Params createMethodCallRequestParams() {
        return new MethodCallRequest.Params();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params.Param }
     * 
     */
    public MethodCallRequest.Params.Param createMethodCallRequestParamsParam() {
        return new MethodCallRequest.Params.Param();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params.Param.Value }
     * 
     */
    public MethodCallRequest.Params.Param.Value createMethodCallRequestParamsParamValue() {
        return new MethodCallRequest.Params.Param.Value();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params.Param.Value.Struct }
     * 
     */
    public MethodCallRequest.Params.Param.Value.Struct createMethodCallRequestParamsParamValueStruct() {
        return new MethodCallRequest.Params.Param.Value.Struct();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params.Param.Value.Struct.Member }
     * 
     */
    public MethodCallRequest.Params.Param.Value.Struct.Member createMethodCallRequestParamsParamValueStructMember() {
        return new MethodCallRequest.Params.Param.Value.Struct.Member();
    }

    /**
     * Create an instance of {@link MethodCallResponse }
     * 
     */
    public MethodCallResponse createMethodCallResponse() {
        return new MethodCallResponse();
    }

    /**
     * Create an instance of {@link MethodCallRequest.Params.Param.Value.Struct.Member.Variable }
     * 
     */
    public MethodCallRequest.Params.Param.Value.Struct.Member.Variable createMethodCallRequestParamsParamValueStructMemberVariable() {
        return new MethodCallRequest.Params.Param.Value.Struct.Member.Variable();
    }

}


package com.hacom.ussdmxaprovisionamiento.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "methodName",
    "params"
})
@XmlRootElement(name = "MethodCallRequest", namespace = "http://www.example.com/provisioning")
public class MethodCallRequest {
	
	@XmlElement(name = "methodName", namespace = "http://www.example.com/provisioning")
    protected String methodName;
	@XmlElement(name = "params", namespace = "http://www.example.com/provisioning")
    protected MethodCallRequest.Params params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String value) {
        this.methodName = value;
    }

    public MethodCallRequest.Params getParams() {
        return params;
    }

    public void setParams(MethodCallRequest.Params value) {
        this.params = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "param"
    })
    public static class Params {

    	@XmlElement(name = "param", namespace = "http://www.example.com/provisioning")
        protected List<MethodCallRequest.Params.Param> param;

        public List<MethodCallRequest.Params.Param> getParam() {
            if (param == null) {
                param = new ArrayList<MethodCallRequest.Params.Param>();
            }
            return this.param;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Param {

        	@XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
            protected MethodCallRequest.Params.Param.Value value;

            public MethodCallRequest.Params.Param.Value getValue() {
                return value;
            }

            public void setValue(MethodCallRequest.Params.Param.Value value) {
                this.value = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "string",
                "struct"
            })
            public static class Value {
            	
            	@XmlElement(name = "string", namespace = "http://www.example.com/provisioning")
                protected String string;
            	@XmlElement(name = "struct", namespace = "http://www.example.com/provisioning")
                protected MethodCallRequest.Params.Param.Value.Struct struct;

                public String getString() {
                    return string;
                }

                public void setString(String value) {
                    this.string = value;
                }

                public MethodCallRequest.Params.Param.Value.Struct getStruct() {
                    return struct;
                }

                public void setStruct(MethodCallRequest.Params.Param.Value.Struct value) {
                    this.struct = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "member"
                })
                public static class Struct {

                	@XmlElement(name = "member", namespace = "http://www.example.com/provisioning")
                    protected List<MethodCallRequest.Params.Param.Value.Struct.Member> member;

                    public List<MethodCallRequest.Params.Param.Value.Struct.Member> getMember() {
                        if (member == null) {
                            member = new ArrayList<MethodCallRequest.Params.Param.Value.Struct.Member>();
                        }
                        return this.member;
                    }


                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "name",
                        "variable"
                    })
                    public static class Member {

                    	@XmlElement(name = "name", namespace = "http://www.example.com/provisioning")
                        protected String name;
                    	@XmlElement(name = "variable", namespace = "http://www.example.com/provisioning")
                        protected MethodCallRequest.Params.Param.Value.Struct.Member.Variable variable;

                        public String getName() {
                            return name;
                        }

                        public void setName(String value) {
                            this.name = value;
                        }

                        public MethodCallRequest.Params.Param.Value.Struct.Member.Variable getVariable() {
                            return variable;
                        }

                        public void setVariable(MethodCallRequest.Params.Param.Value.Struct.Member.Variable value) {
                            this.variable = value;
                        }

                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "string"
                        })
                        public static class Variable {

                        	@XmlElement(name = "string", namespace = "http://www.example.com/provisioning")
                            protected String string;

                            public String getString() {
                                return string;
                            }

                            public void setString(String value) {
                                this.string = value;
                            }

                        }

                    }

                }

            }

        }

    }

}

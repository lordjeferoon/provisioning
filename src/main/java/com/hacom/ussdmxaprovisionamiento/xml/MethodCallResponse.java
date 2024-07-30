
package com.hacom.ussdmxaprovisionamiento.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "params", "fault" })
@XmlRootElement(name = "MethodCallResponse")
public class MethodCallResponse {

    @XmlElement(name = "params", namespace = "http://www.example.com/provisioning")
    protected MethodCallResponse.Params params;

    @XmlElement(name = "fault", namespace = "http://www.example.com/provisioning")
    protected MethodCallResponse.Fault fault;

    public MethodCallResponse.Params getParams() {
        return params;
    }

    public void setParams(MethodCallResponse.Params value) {
        this.params = value;
    }

    public MethodCallResponse.Fault getFault() {
        return fault;
    }

    public void setFault(MethodCallResponse.Fault value) {
        this.fault = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "param" })
    public static class Params {

        @XmlElement(name = "param", namespace = "http://www.example.com/provisioning")
        protected List<MethodCallResponse.Params.Param> param;

        public List<MethodCallResponse.Params.Param> getParam() {
            if (param == null) {
                param = new ArrayList<>();
            }
            return this.param;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "value" })
        public static class Param {

            @XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
            protected MethodCallResponse.Params.Param.Value value;

            public MethodCallResponse.Params.Param.Value getValue() {
                return value;
            }

            public void setValue(MethodCallResponse.Params.Param.Value value) {
                this.value = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "booleanValue" })
            public static class Value {

                @XmlElement(name = "boolean", namespace = "http://www.example.com/provisioning")
                protected int booleanValue;

                public int isBooleanValue() {
                    return booleanValue;
                }

                public void setBooleanValue(int value) {
                    this.booleanValue = value;
                }
            }
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class Fault {

        @XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
        protected MethodCallResponse.Fault.FaultValue value;

        public MethodCallResponse.Fault.FaultValue getValue() {
            return value;
        }

        public void setValue(MethodCallResponse.Fault.FaultValue value) {
            this.value = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "struct" })
        public static class FaultValue {

            @XmlElement(name = "struct", namespace = "http://www.example.com/provisioning")
            protected MethodCallResponse.Fault.FaultValue.FaultStruct struct;

            public MethodCallResponse.Fault.FaultValue.FaultStruct getStruct() {
                return struct;
            }

            public void setStruct(MethodCallResponse.Fault.FaultValue.FaultStruct struct) {
                this.struct = struct;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "member" })
            public static class FaultStruct {

                @XmlElement(name = "member", namespace = "http://www.example.com/provisioning")
                protected List<MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember> member;

                public List<MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember> getMember() {
                    if (member == null) {
                        member = new ArrayList<>();
                    }
                    return this.member;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "name", "value" })
                public static class FaultMember {

                    @XmlElement(name = "name", namespace = "http://www.example.com/provisioning")
                    protected String name;

                    @XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
                    protected MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue value;

                    public String getName() {
                        return name;
                    }

                    public void setName(String value) {
                        this.name = value;
                    }

                    public MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue getValue() {
                        return value;
                    }

                    public void setValue(MethodCallResponse.Fault.FaultValue.FaultStruct.FaultMember.MemberValue value) {
                        this.value = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = { "intValue", "stringValue" })
                    public static class MemberValue {

                        @XmlElement(name = "int", namespace = "http://www.example.com/provisioning")
                        protected Integer intValue;

                        @XmlElement(name = "string", namespace = "http://www.example.com/provisioning")
                        protected String stringValue;

                        public Integer getIntValue() {
                            return intValue;
                        }

                        public void setIntValue(Integer value) {
                            this.intValue = value;
                        }

                        public String getStringValue() {
                            return stringValue;
                        }

                        public void setStringValue(String value) {
                            this.stringValue = value;
                        }
                    }
                }
            }
        }
    }
}


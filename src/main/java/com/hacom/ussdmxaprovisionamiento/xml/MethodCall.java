package com.hacom.ussdmxaprovisionamiento.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "MethodCallRequest", namespace = "http://www.example.com/provisioning")
@XmlAccessorType(XmlAccessType.FIELD)
public class MethodCall {

	@XmlElement(name = "methodName", namespace = "http://www.example.com/provisioning")
	private String methodName;

	@XmlElement(name = "params", namespace = "http://www.example.com/provisioning")
	private Params params;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public static class Params {
		@XmlElement(name = "param", namespace = "http://www.example.com/provisioning")
		private List<Param> param;

		public List<Param> getParam() {
			return param;
		}

		public void setParam(List<Param> param) {
			this.param = param;
		}

		public static class Param {
			@XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
			private Value value;

			public Value getValue() {
				return value;
			}

			public void setValue(Value value) {
				this.value = value;
			}

			public static class Value {
				@XmlElement(name = "string", namespace = "http://www.example.com/provisioning")
				private String string;

				@XmlElement(name = "struct", namespace = "http://www.example.com/provisioning")
				private Struct struct;

				public String getString() {
					return string;
				}

				public void setString(String string) {
					this.string = string;
				}

				public Struct getStruct() {
					return struct;
				}

				public void setStruct(Struct struct) {
					this.struct = struct;
				}

				public static class Struct {
					@XmlElement(name = "member", namespace = "http://www.example.com/provisioning")
					private List<Member> member;

					public List<Member> getMember() {
						return member;
					}

					public void setMember(List<Member> member) {
						this.member = member;
					}

					public static class Member {
						@XmlElement(name = "name", namespace = "http://www.example.com/provisioning")
						private String name;

						@XmlElement(name = "value", namespace = "http://www.example.com/provisioning")
						private MemberValue value;

						public String getName() {
							return name;
						}

						public void setName(String name) {
							this.name = name;
						}

						public MemberValue getValue() {
							return value;
						}

						public void setValue(MemberValue value) {
							this.value = value;
						}

						public static class MemberValue {

							@XmlElement(name = "string", namespace = "http://www.example.com/provisioning")
							private String value;

							public String getValue() {
								return value;
							}

							public void setValue(String value) {
								this.value = value;
							}

						}

					}
				}
			}
		}
	}
}

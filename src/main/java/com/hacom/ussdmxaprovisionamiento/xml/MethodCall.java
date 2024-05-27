package com.hacom.ussdmxaprovisionamiento.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "methodCall")
@XmlAccessorType(XmlAccessType.FIELD)
public class MethodCall {

	private String methodName;
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
		private List<Param> param;

		public List<Param> getParam() {
			return param;
		}

		public void setParam(List<Param> param) {
			this.param = param;
		}

		public static class Param {
			private Value value;

			public Value getValue() {
				return value;
			}

			public void setValue(Value value) {
				this.value = value;
			}

			public static class Value {
				private String string;
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
					private List<Member> member;

					public List<Member> getMember() {
						return member;
					}

					public void setMember(List<Member> member) {
						this.member = member;
					}

					public static class Member {
						private String name;
						private Value value;

						public String getName() {
							return name;
						}

						public void setName(String name) {
							this.name = name;
						}

						public Value getValue() {
							return value;
						}

						public void setValue(Value value) {
							this.value = value;
						}

					}
				}
			}
		}
	}

}

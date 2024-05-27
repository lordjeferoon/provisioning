package com.hacom.ussdmxaprovisionamiento.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "MethodCallResponse", namespace = "http://www.example.com/provisioning")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

	@XmlElement(name = "result", namespace = "http://www.example.com/provisioning")
	private String result;

	@XmlElement(name = "message", namespace = "http://www.example.com/provisioning")
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String result, String message) {
		this.result = result;
		this.message = message;
	}
}

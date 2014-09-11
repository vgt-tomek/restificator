package pl.vgtworld.restificator.data;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import pl.vgtworld.restificator.data.requests.Request;

@XmlRootElement(name = "restificator")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestificatorExecutionData {
	
	@XmlElementWrapper(name = "globalHeaders")
	private Map<String, String> globalHeaders = new HashMap<>();
	
	@XmlElementWrapper(name = "requests")
	private Map<String, Request> requests = new HashMap<>();
	
	public Map<String, String> getGlobalHeaders() {
		return globalHeaders;
	}
	
	public void setGlobalHeaders(Map<String, String> globalHeaders) {
		this.globalHeaders = globalHeaders;
	}
	
	public Map<String, Request> getRequests() {
		return requests;
	}
	
	public void setRequests(Map<String, Request> requests) {
		this.requests = requests;
	}
	
	@Override
	public String toString() {
		return "RestificatorExecutionData [\nglobalHeaders=" + globalHeaders + ", \nrequests=" + requests + "\n]";
	}
	
}

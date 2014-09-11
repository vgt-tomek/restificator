package pl.vgtworld.restificator.data;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import pl.vgtworld.restificator.data.requests.Request;

@XmlRootElement(name = "restificator")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestificatorExecutionData {
	
	@XmlElementWrapper(name = "requests")
	private Map<String, Request> requests;
	
	public Map<String, Request> getRequests() {
		return requests;
	}
	
	public void setRequests(Map<String, Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "RestificatorExecutionData [\nrequests=" + requests + "\n]";
	}
	
}

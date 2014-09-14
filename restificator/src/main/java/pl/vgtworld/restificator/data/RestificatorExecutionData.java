package pl.vgtworld.restificator.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.parameters.Parameters;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.data.settings.Settings;

@XmlRootElement(name = "restificator")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestificatorExecutionData {
	
	private Settings settings;
	
	@XmlElementWrapper(name = "globalHeaders")
	@XmlElement(name = "header")
	private List<Header> globalHeaders = new ArrayList<>();
	
	private Parameters parameters = new Parameters();
	
	@XmlElementWrapper(name = "tasks")
	@XmlElement(name = "task")
	private List<Task> tasks = new ArrayList<>();
	
	@XmlElementWrapper(name = "requests")
	private Map<String, Request> requests = new HashMap<>();
	
	public Settings getSettings() {
		return settings;
	}
	
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public List<Header> getGlobalHeaders() {
		return globalHeaders;
	}
	
	public void setGlobalHeaders(List<Header> globalHeaders) {
		this.globalHeaders = globalHeaders;
	}
	
	public Parameters getParameters() {
		return parameters;
	}
	
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public Map<String, Request> getRequests() {
		return requests;
	}
	
	public void setRequests(Map<String, Request> requests) {
		this.requests = requests;
	}
	
	@Override
	public String toString() {
		return "RestificatorExecutionData [\nsettings=" + settings + ",\nglobalHeaders=" + globalHeaders
				+ ",\nparameters=" + parameters + ",\ntasks=" + tasks + ",\nrequests=" + requests + "\n]";
	}
	
}

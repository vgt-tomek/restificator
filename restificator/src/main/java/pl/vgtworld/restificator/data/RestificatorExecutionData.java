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
import pl.vgtworld.restificator.data.requests.Request;

@XmlRootElement(name = "restificator")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestificatorExecutionData {
	
	@XmlElementWrapper(name = "globalHeaders")
	private Map<String, String> globalHeaders = new HashMap<>();
	
	@XmlElementWrapper(name = "tasks")
	@XmlElement(name = "task")
	private List<Task> tasks = new ArrayList<>();
	
	@XmlElementWrapper(name = "requests")
	private Map<String, Request> requests = new HashMap<>();
	
	public Map<String, String> getGlobalHeaders() {
		return globalHeaders;
	}
	
	public void setGlobalHeaders(Map<String, String> globalHeaders) {
		this.globalHeaders = globalHeaders;
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
		return "RestificatorExecutionData [\nglobalHeaders=" + globalHeaders + ",\ntasks=" + tasks + ",\nrequests="
				+ requests + "\n]";
	}
	
}

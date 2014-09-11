package pl.vgtworld.restificator.data.requests;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private RequestType type;
	
	private String path;
	
	private Map<String, String> headers = new HashMap<>();
	
	private String body;
	
	public RequestType getType() {
		return type;
	}
	
	public void setType(RequestType type) {
		this.type = type;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Request [type=" + type + ", path=" + path + ", headers=" + headers + ", body=" + body + "]";
	}
	
}

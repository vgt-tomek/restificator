package pl.vgtworld.restificator.data.requests;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import pl.vgtworld.restificator.data.headers.Header;

@XmlAccessorType(XmlAccessType.FIELD)
public class Request {
	
	private RequestType type;
	
	private String path;
	
	@XmlElementWrapper(name = "headers")
	@XmlElement(name = "header")
	private List<Header> headers;
	
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
	
	public List<Header> getHeaders() {
		return headers;
	}
	
	public void setHeaders(List<Header> headers) {
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

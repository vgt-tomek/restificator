package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.requests.RequestType;

import java.util.List;

class TableRowDataModel {

	private String name;

	private RequestType type;

	private String path;

	private String body;

	private List<Header> headers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

}

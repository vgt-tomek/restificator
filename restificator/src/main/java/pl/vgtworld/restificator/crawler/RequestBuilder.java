package pl.vgtworld.restificator.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.requests.Request;

class RequestBuilder {
	
	private List<Header> globalHeaders;
	
	private Map<String, Parameter> parameters;

	private String prefix;

	private String suffix;
	
	public RequestBuilder(List<Header> globalHeaders, Map<String, Parameter> mergedParameters) {
		this.globalHeaders = globalHeaders;
		parameters = mergedParameters;
	}

	public void setPlaceholderBoundaries(String placeholderPrefix, String placeholderSuffix) {
		prefix = placeholderPrefix;
		suffix = placeholderSuffix;
	}

	public String buildRequest(Request requestTemplate) {
		StringBuilder request = new StringBuilder();
		request.append(requestTemplate.getType()).append(" ").append(requestTemplate.getPath()).append(" HTTP/1.0\n");
		
		addHeadersToRequest(requestTemplate, request);
		for (Parameter param : parameters.values()) {
			findAndReplacePlaceholder(request, param);
		}
		
		if (requestTemplate.getBody() != null && requestTemplate.getBody().length() > 0) {
			request.append("Content-length: ").append(requestTemplate.getBody().length()).append("\n\n");
			request.append(requestTemplate.getBody());
		}
		
		
		request.append("\n");
		
		return request.toString();
	}

	private void addHeadersToRequest(Request requestTemplate, StringBuilder request) {
		List<Header> mergedHeaders = mergeHeaders(globalHeaders, requestTemplate.getHeaders());
		for (Header header : mergedHeaders) {
			request.append(header.getName()).append(": ").append(header.getValue()).append("\n");
		}
	}
	
	private List<Header> mergeHeaders(List<Header> global, List<Header> local) {
		Map<String, Header> mergedHeaders = new HashMap<>();
		for (Header header : global) {
			mergedHeaders.put(header.getName(), header);
		}
		for (Header header : local) {
			mergedHeaders.put(header.getName(), header);
		}
		return new ArrayList<Header>(mergedHeaders.values());
	}
	
	private void findAndReplacePlaceholder(StringBuilder text, Parameter parameter) {
		String placeholder = prefix + parameter.getName() + suffix;
		int index = text.indexOf(placeholder);
		if (index > -1) {
			text.replace(index, index + placeholder.length(), parameter.getParameterValue());
		}
	}
}

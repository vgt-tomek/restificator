package pl.vgtworld.restificator.validator;

import java.util.ArrayList;
import java.util.List;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.data.requests.RequestType;

public final class RequestsFactory {
	
	private RequestsFactory() {
	}
	
	public static Request getNewInstance() {
		Request request = new Request();
		List<Header> headers = new ArrayList<>();
		Header header = new Header();
		header.setName("header-name");
		header.setValue("header-value");
		headers.add(header);
		request.setHeaders(headers);
		request.setType(RequestType.POST);
		request.setPath("/request/path");
		request.setBody("request body");
		return request;
	}
	
}

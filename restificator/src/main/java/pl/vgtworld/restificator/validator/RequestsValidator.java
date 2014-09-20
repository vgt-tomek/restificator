package pl.vgtworld.restificator.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.requests.Request;

class RequestsValidator {
	
	enum ErrorMessages {
		
		REQUESTS_REQUIRED("Requests node is required."),
		KEY_REQUIRED("Request key is required."),
		REQUEST_REQUIRED("Request value node is missing for '%s' key."),
		HEADERS_REQUIRED("Headers node is missing in '%s' request."),
		HEADER_NAME_REQUIRED("Header name is missing in '%s' request."),
		HEADER_VALUE_REQUIRED("Header value is missing in '%s' request and '%s' header."),
		HEADER_NAME_UNIQUE("Headers should be unique. Header with name '%s' has duplicate in '%s' request."),
		TYPE_REQUIRED("Type is missing or invalid value is used in '%s' request."),
		PATH_REQUIRED("Path is missing in '%s' request.");
		
		private String message;
		
		String getMessage() {
			return message;
		}
		
		private ErrorMessages(String message) {
			this.message = message;
		}
	}

	void validate(Map<String, Request> requests) throws XmlValidationException {
		if (requests == null) {
			throw new XmlValidationException(ErrorMessages.REQUESTS_REQUIRED.getMessage());
		}
		validateRequests(requests);
	}

	private void validateRequests(Map<String, Request> requests) throws XmlValidationException {
		for (String key : requests.keySet()) {
			if (key == null || key.length() == 0) {
				throw new XmlValidationException(ErrorMessages.KEY_REQUIRED.getMessage());
			}
			Request request = requests.get(key);
			if (request == null) {
				String message = String.format(ErrorMessages.REQUEST_REQUIRED.getMessage(), key);
				throw new XmlValidationException(message);
			}
			validateRequest(key, request);
		}
	}

	private void validateRequest(String key, Request request) throws XmlValidationException {
		validateRequestHeaders(key, request);
		if (request.getType() == null) {
			String message = String.format(ErrorMessages.TYPE_REQUIRED.getMessage(), key);
			throw new XmlValidationException(message);
		}
		if (request.getPath() == null || request.getPath().length() == 0) {
			String message = String.format(ErrorMessages.PATH_REQUIRED.getMessage(), key);
			throw new XmlValidationException(message);
		}
	}

	private void validateRequestHeaders(String key, Request request) throws XmlValidationException {
		if (request.getHeaders() == null) {
			String message = String.format(ErrorMessages.HEADERS_REQUIRED.getMessage(), key);
			throw new XmlValidationException(message);
		}
		List<String> names = new ArrayList<>();
		for (Header header : request.getHeaders()) {
			if (header.getName() == null || header.getName().length() == 0) {
				String message = String.format(ErrorMessages.HEADER_NAME_REQUIRED.getMessage(), key);
				throw new XmlValidationException(message);
			}
			if (header.getValue() == null || header.getValue().length() == 0) {
				String message = String.format(ErrorMessages.HEADER_VALUE_REQUIRED.getMessage(), key, header.getName());
				throw new XmlValidationException(message);
			}
			if (names.contains(header.getName())) {
				String message = String.format(ErrorMessages.HEADER_NAME_UNIQUE.getMessage(), header.getName(), key);
				throw new XmlValidationException(message);
			}
			names.add(header.getName());
		}
	}
}

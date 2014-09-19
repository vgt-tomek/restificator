package pl.vgtworld.restificator.validator;

import java.util.ArrayList;
import java.util.List;

import pl.vgtworld.restificator.data.headers.Header;

class GlobalHeadersValidator {
	
	enum ErrorMessages {
		
		GLOBAL_HEADERS_REQUIRED("Global headers node is required."),
		NAME_REQUIRED("Global header name is missing."),
		NAME_UNIQUE("Global headers should be unique. Header with name '%s' has duplicate."),
		VALUE_REQUIRED("Value is missing for '%s' global header.");
		
		private String message;
		
		String getMessage() {
			return message;
		}
		
		private ErrorMessages(String message) {
			this.message = message;
		}
	}
	
	void validate(List<Header> globalHeaders) throws XmlValidationException {
		if (globalHeaders == null) {
			throw new XmlValidationException(ErrorMessages.GLOBAL_HEADERS_REQUIRED.getMessage());
		}
		for (Header header : globalHeaders) {
			validateHeader(header);
		}
		validateHeadersUniqueness(globalHeaders);
	}
	
	private void validateHeader(Header header) throws XmlValidationException {
		if (header.getName() == null || header.getName().length() == 0) {
			throw new XmlValidationException(ErrorMessages.NAME_REQUIRED.getMessage());
		}
		if (header.getValue() == null || header.getValue().length() == 0) {
			String message = String.format(ErrorMessages.VALUE_REQUIRED.getMessage(), header.getName());
			throw new XmlValidationException(message);
		}
	}
	
	private void validateHeadersUniqueness(List<Header> headers) throws XmlValidationException {
		List<String> names = new ArrayList<>();
		for (Header header : headers) {
			if (names.contains(header.getName())) {
				String message = String.format(ErrorMessages.NAME_UNIQUE.getMessage(), header.getName());
				throw new XmlValidationException(message);
			}
			names.add(header.getName());
		}
	}
}

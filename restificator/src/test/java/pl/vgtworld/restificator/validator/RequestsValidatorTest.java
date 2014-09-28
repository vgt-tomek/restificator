package pl.vgtworld.restificator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.data.requests.RequestType;

public class RequestsValidatorTest {
	
	private RequestsValidator validator = new RequestsValidator();
	
	@Test
	public void shouldThrowExceptionWhenRequestsNodeIsMissing() {
		String expectedErrorMessage = RequestsValidator.ErrorMessages.REQUESTS_REQUIRED.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(null);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenRequestKeyIsNull() {
		String expectedErrorMessage = RequestsValidator.ErrorMessages.KEY_REQUIRED.getMessage();
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		requests.put(null, createValidRequest());
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenRequestKeyIsEmpty() {
		String expectedErrorMessage = RequestsValidator.ErrorMessages.KEY_REQUIRED.getMessage();
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		requests.put("", createValidRequest());
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenRequestIsMissing() {
		String missingRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.REQUEST_REQUIRED.getMessage(),
				missingRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		requests.put(missingRequestKey, null);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeadersNodeIsMissing() {
		String invalidRequestKey = "other-requestKey";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADERS_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		invalidRequest.setHeaders(null);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderNameIsNull() {
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADER_NAME_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		Header invalidHeader = new Header();
		invalidHeader.setValue("header-value");
		invalidRequest.getHeaders().add(invalidHeader);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderNameIsEmpty() {
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADER_NAME_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		Header invalidHeader = new Header();
		invalidHeader.setName("");
		invalidHeader.setValue("header-value");
		invalidRequest.getHeaders().add(invalidHeader);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderValueIsNull() {
		String invalidRequestKey = "request-key";
		String invalidHeaderName = "invalid-header-name";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADER_VALUE_REQUIRED.getMessage(),
				invalidRequestKey,
				invalidHeaderName
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		Header invalidHeader = new Header();
		invalidHeader.setName(invalidHeaderName);
		invalidHeader.setValue(null);
		invalidRequest.getHeaders().add(invalidHeader);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderValueIsEmpty() {
		String invalidRequestKey = "request-key";
		String invalidHeaderName = "invalid-header-name";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADER_VALUE_REQUIRED.getMessage(),
				invalidRequestKey,
				invalidHeaderName
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		Header invalidHeader = new Header();
		invalidHeader.setName(invalidHeaderName);
		invalidHeader.setValue("");
		invalidRequest.getHeaders().add(invalidHeader);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTwoHeadersInRequestUseTheSameName() {
		String invalidHeaderName = "invalid-header-name";
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.HEADER_NAME_UNIQUE.getMessage(),
				invalidHeaderName,
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		Header firstHeader = new Header();
		firstHeader.setName(invalidHeaderName);
		firstHeader.setValue("first-value");
		Header secondHeader = new Header();
		secondHeader.setName(invalidHeaderName);
		secondHeader.setValue("second-value");
		invalidRequest.getHeaders().add(firstHeader);
		invalidRequest.getHeaders().add(secondHeader);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTypeIsNull() {
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.TYPE_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		invalidRequest.setType(null);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPathIsNull() {
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.PATH_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		invalidRequest.setPath(null);
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPathIsEmpty() {
		String invalidRequestKey = "request-key";
		String expectedErrorMessage = String.format(
				RequestsValidator.ErrorMessages.PATH_REQUIRED.getMessage(),
				invalidRequestKey
				);
		String errorMessage = null;
		Map<String, Request> requests = new HashMap<>();
		Request invalidRequest = createValidRequest();
		invalidRequest.setPath("");
		requests.put(invalidRequestKey, invalidRequest);
		
		try {
			validator.validate(requests);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldAcceptValidRequestsMap() throws XmlValidationException {
		Map<String, Request> requests = new HashMap<>();
		requests.put("request-key", createValidRequest());
		
		validator.validate(requests);
	}
	
	private Request createValidRequest() {
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

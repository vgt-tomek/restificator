package pl.vgtworld.restificator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pl.vgtworld.restificator.data.headers.Header;

public class GlobalHeadersValidatorTest {
	
	private static final String HEADER_NAME = "some-header";

	private GlobalHeadersValidator validator = new GlobalHeadersValidator();
	
	@Test
	public void shouldThrowExceptionWhenHeadersListIsMissing() {
		String expectedErrorMessage = GlobalHeadersValidator.ErrorMessages.GLOBAL_HEADERS_REQUIRED.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(null);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderNameIsNull() {
		String expectedErrorMessage = GlobalHeadersValidator.ErrorMessages.NAME_REQUIRED.getMessage();
		String errorMessage = null;
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader(null, "some value"));
		
		try {
			validator.validate(headers);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}

	@Test
	public void shouldThrowExcepionWhenHeaderNameIsEmpty() {
		String expectedErrorMessage = GlobalHeadersValidator.ErrorMessages.NAME_REQUIRED.getMessage();
		String errorMessage = null;
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader("", "some value"));
		
		try {
			validator.validate(headers);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTwoHeadersAreUsingTheSameName() {
		String expectedErrorMessage = String.format(
				GlobalHeadersValidator.ErrorMessages.NAME_UNIQUE.getMessage(),
				HEADER_NAME
				);
		String errorMessage = null;
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader(HEADER_NAME, "some value"));
		headers.add(createHeader(HEADER_NAME, "some other value"));
		
		try {
			validator.validate(headers);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHeaderValueIsNull() {
		String expectedErrorMessage = String.format(
				GlobalHeadersValidator.ErrorMessages.VALUE_REQUIRED.getMessage(),
				HEADER_NAME
				);
		String errorMessage = null;
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader(HEADER_NAME, null));
		
		try {
			validator.validate(headers);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}

	@Test
	public void shouldThrowExceptionWhenHeaderValueIsEmpty() {
		String expectedErrorMessage = String.format(
				GlobalHeadersValidator.ErrorMessages.VALUE_REQUIRED.getMessage(),
				HEADER_NAME
				);
		String errorMessage = null;
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader(HEADER_NAME, ""));
		
		try {
			validator.validate(headers);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldAcceptEmptyHeaderList() throws XmlValidationException {
		validator.validate(new ArrayList<Header>());
	}
	
	@Test
	public void shouldAcceptFilledHeaderList() throws XmlValidationException {
		List<Header> headers = new ArrayList<>();
		headers.add(createHeader(HEADER_NAME, "some value"));
		
		validator.validate(headers);
	}

	private Header createHeader(String name, String value) {
		Header header = new Header();
		header.setName(name);
		header.setValue(value);
		return header;
	}
}

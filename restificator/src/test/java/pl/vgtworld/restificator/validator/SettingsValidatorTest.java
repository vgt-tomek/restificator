package pl.vgtworld.restificator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import pl.vgtworld.restificator.data.settings.Settings;

public class SettingsValidatorTest {
	
	private SettingsValidator validator = new SettingsValidator();
	
	@Test
	public void shouldThrowExceptionWhenSettingsNodeIsMissing() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.SETTINGS_REQUIRED.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(null);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHostIsNull() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.HOST_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setHost(null);
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenHostIsEmpty() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.HOST_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setHost("");
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPortIsNull() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.PORT_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPort(null);
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPortIsEmpty() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.PORT_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPort("");
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPortIsNotANumber() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.PORT_INVALID_VALUE.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPort("80AB");
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPlaceholderPrefixIsNull() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.PREFIX_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPlaceholderPrefix(null);
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPlaceholderPrefixIsEmpty() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.PREFIX_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPlaceholderPrefix("");
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPlaceholderSuffixIsNull() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.SUFFIX_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPlaceholderSuffix(null);
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPlaceholderSuffixIsEmpty() {
		String expectedErrorMessage = SettingsValidator.ErrorMessages.SUFFIX_REQUIRED.getMessage();
		String errorMessage = null;
		Settings settings = createValidSettingsObject();
		settings.setPlaceholderSuffix("");
		
		try {
			validator.validate(settings);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldAcceptValidSettingsObject() throws XmlValidationException {
		validator.validate(createValidSettingsObject());
	}
	
	private Settings createValidSettingsObject() {
		Settings settings = new Settings();
		settings.setHost("localhost");
		settings.setPort("8080");
		settings.setPlaceholderPrefix("{{");
		settings.setPlaceholderSuffix("}}");
		return settings;
	}
}

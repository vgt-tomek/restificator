package pl.vgtworld.restificator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Parameters;
import pl.vgtworld.restificator.data.parameters.Text;

public class ParametersValidatorTest {
	
	private ParametersValidator validator = new ParametersValidator();

	@Test
	public void shouldThrowExceptionWhenParametersNodeIsMissing() {
		String expectedErrorMessage = ParametersValidator.ErrorMessages.PARAMETERS_REQUIRED.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(null);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenInteractiveParametersListIsMissing() {
		String expectedErrorMessage = ParametersValidator.ErrorMessages.INTERACTIVE_PARAMETERS_REQUIRED.getMessage();
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.setInteractiveParameters(null);
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPredefinedParametersListIsMissing() {
		String expectedErrorMessage = ParametersValidator.ErrorMessages.PREDEFINED_PARAMETERS_REQUIRED.getMessage();
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.setPredefinedParameters(null);
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenParameterNameIsNull() {
		String expectedErrorMessage = ParametersValidator.ErrorMessages.PARAMETER_NAME_REQUIRED.getMessage();
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.getPredefinedParameters().add(new Text(null, "some value"));
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenParameterNameIsEmpty() {
		String expectedErrorMessage = ParametersValidator.ErrorMessages.PARAMETER_NAME_REQUIRED.getMessage();
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.getPredefinedParameters().add(new Text("", "some value"));
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenInteractiveParametersHaveDuplicates() {
		String parameterName = "duplicated-name";
		String expectedErrorMessage = String.format(
				ParametersValidator.ErrorMessages.NAME_UNIQUE.getMessage(),
				parameterName
				);
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.getInteractiveParameters().add(new Text(parameterName, "value 1"));
		parameters.getInteractiveParameters().add(new Text(parameterName, "value 2"));
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenPredefinedParametersHaveDuplicates() {
		String parameterName = "duplicated-name";
		String expectedErrorMessage = String.format(
				ParametersValidator.ErrorMessages.NAME_UNIQUE.getMessage(),
				parameterName
				);
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.getPredefinedParameters().add(new Text(parameterName, "value 1"));
		parameters.getPredefinedParameters().add(new Text(parameterName, "value 2"));
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenParametersHaveDuplicates() {
		String parameterName = "duplicated-name";
		String expectedErrorMessage = String.format(
				ParametersValidator.ErrorMessages.NAME_UNIQUE.getMessage(),
				parameterName
				);
		String errorMessage = null;
		Parameters parameters = createValidParametersObject();
		parameters.getInteractiveParameters().add(new Text(parameterName, "value 1"));
		parameters.getPredefinedParameters().add(new Text(parameterName, "value 2"));
		
		try {
			validator.validate(parameters);
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldAcceptValidParametersObject() throws XmlValidationException {
		validator.validate(createValidParametersObject());
	}
	
	private Parameters createValidParametersObject() {
		Parameters parameters = new Parameters();
		List<Parameter> interactiveParameters = new ArrayList<>();
		interactiveParameters.add(new Text("interactive name 1", "interactive value 1"));
		interactiveParameters.add(new Text("interactive name 2", "interactive value 2"));
		List<Parameter> predefinedParameters = new ArrayList<>();
		predefinedParameters.add(new Text("predefined name 1", "predefined value 1"));
		predefinedParameters.add(new Text("predefined name 2", "predefined value 2"));
		parameters.setInteractiveParameters(interactiveParameters);
		parameters.setPredefinedParameters(predefinedParameters);
		return parameters;
	}
	
}

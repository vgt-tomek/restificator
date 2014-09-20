package pl.vgtworld.restificator.validator;

import java.util.ArrayList;
import java.util.List;

import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Parameters;

class ParametersValidator {
	
	enum ErrorMessages {
		
		PARAMETERS_REQUIRED("Parameters node is required."),
		INTERACTIVE_PARAMETERS_REQUIRED("Interactive parameters node is required."),
		PREDEFINED_PARAMETERS_REQUIRED("Predefined parameters node is required."),
		PARAMETER_NAME_REQUIRED("Parameter name is missing."),
		NAME_UNIQUE("Parameters should be unique. Parameter with name '%s' has duplicate.");
		
		private String message;
		
		String getMessage() {
			return message;
		}
		
		private ErrorMessages(String message) {
			this.message = message;
		}
	}

	void validate(Parameters parameters) throws XmlValidationException {
		validateMainNodes(parameters);
		validateNames(parameters);
		validateNameUniqueness(parameters);
	}
	
	private void validateMainNodes(Parameters parameters) throws XmlValidationException {
		if (parameters == null) {
			throw new XmlValidationException(ErrorMessages.PARAMETERS_REQUIRED.getMessage());
		}
		if (parameters.getInteractiveParameters() == null) {
			throw new XmlValidationException(ErrorMessages.INTERACTIVE_PARAMETERS_REQUIRED.getMessage());
		}
		if (parameters.getPredefinedParameters() == null) {
			throw new XmlValidationException(ErrorMessages.PREDEFINED_PARAMETERS_REQUIRED.getMessage());
		}
	}
	
	private void validateNames(Parameters parameters) throws XmlValidationException {
		validateParameters(parameters.getInteractiveParameters());
		validateParameters(parameters.getPredefinedParameters());
	}

	private void validateParameters(List<Parameter> interactiveParameters) throws XmlValidationException {
		for (Parameter parameter : interactiveParameters) {
			if (parameter.getName() == null || parameter.getName().length() == 0) {
				throw new XmlValidationException(ErrorMessages.PARAMETER_NAME_REQUIRED.getMessage());
			}
		}
	}
	
	private void validateNameUniqueness(Parameters parameters) throws XmlValidationException {
		List<String> names = new ArrayList<>();
		validateNameUniqueness(names, parameters.getInteractiveParameters());
		validateNameUniqueness(names, parameters.getPredefinedParameters());
	}

	private void validateNameUniqueness(List<String> names, List<Parameter> interactiveParameters)
			throws XmlValidationException {
		for (Parameter parameter : interactiveParameters) {
			if (names.contains(parameter.getName())) {
				String message = String.format(ErrorMessages.NAME_UNIQUE.getMessage(), parameter.getName());
				throw new XmlValidationException(message);
			}
			names.add(parameter.getName());
		}
	}
}

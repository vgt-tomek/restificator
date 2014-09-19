package pl.vgtworld.restificator.validator;

import pl.vgtworld.restificator.data.settings.Settings;

class SettingsValidator {
	
	enum ErrorMessages {
		
		SETTINGS_REQUIRED("Settings node is required."),
		HOST_REQUIRED("Host in settings is missing."),
		PORT_REQUIRED("Port in settings is missing."),
		PORT_INVALID_VALUE("Port should be a number."),
		PREFIX_REQUIRED("Placeholder prefix in settings is missing."),
		SUFFIX_REQUIRED("Placeholder suffix in settings is missing.");
		
		private String message;
		
		String getMessage() {
			return message;
		}
		
		private ErrorMessages(String message) {
			this.message = message;
		}
	}
	
	void validate(Settings settings) throws XmlValidationException {
		if (settings == null) {
			throw new XmlValidationException(ErrorMessages.SETTINGS_REQUIRED.getMessage());
		}
		validateConnectionParameters(settings);
		validatePlaceholder(settings);
	}
	
	private void validateConnectionParameters(Settings settings) throws XmlValidationException {
		if (settings.getHost() == null || settings.getHost().length() == 0) {
			throw new XmlValidationException(ErrorMessages.HOST_REQUIRED.getMessage());
		}
		if (settings.getPort() == null || settings.getPort().length() == 0) {
			throw new XmlValidationException(ErrorMessages.PORT_REQUIRED.getMessage());
		}
		try {
			int port = Integer.parseInt(settings.getPort());
			if (port <= 0) {
				throw new XmlValidationException(ErrorMessages.PORT_INVALID_VALUE.getMessage());
			}
		} catch (NumberFormatException e) {
			throw new XmlValidationException(ErrorMessages.PORT_INVALID_VALUE.getMessage(), e);
		}
	}
	
	private void validatePlaceholder(Settings settings) throws XmlValidationException {
		if (settings.getPlaceholderPrefix() == null || settings.getPlaceholderPrefix().length() == 0) {
			throw new XmlValidationException(ErrorMessages.PREFIX_REQUIRED.getMessage());
		}
		if (settings.getPlaceholderSuffix() == null || settings.getPlaceholderSuffix().length() == 0) {
			throw new XmlValidationException(ErrorMessages.SUFFIX_REQUIRED.getMessage());
		}
	}
}

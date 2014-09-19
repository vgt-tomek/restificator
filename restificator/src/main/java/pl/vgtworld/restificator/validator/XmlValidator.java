package pl.vgtworld.restificator.validator;

import pl.vgtworld.restificator.data.RestificatorExecutionData;

public class XmlValidator {
	
	private String error;
	
	public String getError() {
		return error;
	}
	
	public boolean validate(RestificatorExecutionData data) {
		try {
			SettingsValidator settings = new SettingsValidator();
			settings.validate(data.getSettings());
			return true;
		} catch (XmlValidationException e) {
			error = e.getMessage();
			return false;
		}
	}
	
}

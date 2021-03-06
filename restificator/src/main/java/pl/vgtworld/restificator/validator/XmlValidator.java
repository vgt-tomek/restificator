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
			GlobalHeadersValidator globalHeaders = new GlobalHeadersValidator();
			globalHeaders.validate(data.getGlobalHeaders());
			ParametersValidator parameters = new ParametersValidator();
			parameters.validate(data.getParameters());
			RequestsValidator requests = new RequestsValidator();
			requests.validate(data.getRequests());
			TasksValidator tasks = new TasksValidator();
			tasks.validate(data.getTasks(), data.getRequests());
			return true;
		} catch (XmlValidationException e) {
			error = e.getMessage();
			return false;
		}
	}
	
}

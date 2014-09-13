package pl.vgtworld.restificator.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.Restificator;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Text;

class ParametersScanner {
	
	private static final Logger OUTPUT = LoggerFactory.getLogger(Restificator.OUTPUT_LOGGER_NAME);
	
	public List<Parameter> readParameters(List<Parameter> parameters) {
		Scanner scanner = new Scanner(System.in);
		List<Parameter> finalParameters = new ArrayList<>();
		for (Parameter parameter : parameters) {
			String description = parameter.getDescription();
			if (description != null && description.length() > 0) {
				OUTPUT.info(description);
			}
			String parameterValue = parameter.getParameterValue();
			if (parameterValue.length() > 0) {
				OUTPUT.info("Default value (if left empty): " + parameterValue);
			}
			OUTPUT.info("New value?");
			String readValue = scanner.nextLine().trim();
			if (readValue.length() == 0) {
				readValue = parameterValue;
			}
			Text finalParameter = new Text(parameter.getName(), readValue);
			finalParameters.add(finalParameter);
			OUTPUT.info("---");
		}
		scanner.close();
		return finalParameters;
	}
}

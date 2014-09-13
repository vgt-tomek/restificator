package pl.vgtworld.restificator.crawler;

import java.util.List;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.data.parameters.Parameter;

public class RestCrawler {
	
	private ParametersScanner parametersScanner = new ParametersScanner();
	
	public void executeScript(RestificatorExecutionData data) {
		List<Parameter> readParameters = parametersScanner
				.readParameters(data.getParameters().getInteractiveParameters());
		System.out.println(readParameters);
	}
}

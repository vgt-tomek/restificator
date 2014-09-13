package pl.vgtworld.restificator.crawler;

import java.util.List;
import java.util.Map;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.data.parameters.Parameter;

public class RestCrawler {
	
	private ParametersScanner parametersScanner = new ParametersScanner();
	
	private ParametersMapper parametersMapper = new ParametersMapper();
	
	public void executeScript(RestificatorExecutionData data) {
		List<Parameter> readParameters = parametersScanner
				.readParameters(data.getParameters().getInteractiveParameters());
		
		Map<String, Parameter> mergedParameters = parametersMapper.mergeParameterLists(
				readParameters,
				data.getParameters().getPredefinedParameters()
				);
	}
}

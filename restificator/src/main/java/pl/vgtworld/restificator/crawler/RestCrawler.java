package pl.vgtworld.restificator.crawler;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.requests.Request;

public class RestCrawler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestCrawler.class);
	
	private ParametersScanner parametersScanner = new ParametersScanner();
	
	private ParametersMapper parametersMapper = new ParametersMapper();
	
	public void executeScript(RestificatorExecutionData data) {
		List<Parameter> readParameters = parametersScanner
				.readParameters(data.getParameters().getInteractiveParameters());
		
		Map<String, Parameter> mergedParameters = parametersMapper.mergeParameterLists(
				readParameters,
				data.getParameters().getPredefinedParameters()
				);
		
		List<Task> tasks = data.getTasks();
		for (Task task : tasks) {
			LOGGER.debug("Execute task {}", task.getName());
			switch (task.getType()) {
			case REQUEST:
				Request request = data.getRequests().get(task.getName());
				break;
			}
			//TODO
		}
	}
}

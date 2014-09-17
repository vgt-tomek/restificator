package pl.vgtworld.restificator.crawler;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.network.NetworkConnector;

public class RestCrawler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestCrawler.class);
	
	private ParametersScanner parametersScanner = new ParametersScanner();
	
	private ParametersMapper parametersMapper = new ParametersMapper();
	
	public void executeScript(RestificatorExecutionData data) throws ExecutionException {
		try {
			List<Parameter> readParameters = readParameters(data);
			
			Map<String, Parameter> mergedParameters = mergeparameters(data, readParameters);
			
			executeTasks(data, mergedParameters);
		} catch (IOException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
	}

	private void executeTasks(RestificatorExecutionData data, Map<String, Parameter> mergedParameters)
			throws UnknownHostException, IOException {
		RequestBuilder requestBuilder = new RequestBuilder(data.getGlobalHeaders(), mergedParameters);
		requestBuilder.setPlaceholderBoundaries(data.getSettings().getPlaceholderPrefix(), data.getSettings().getPlaceholderSuffix());
		int connectionPort = Integer.parseInt(data.getSettings().getPort());
		NetworkConnector connector = new NetworkConnector(data.getSettings().getHost(), connectionPort);
		List<Task> tasks = data.getTasks();
		for (Task task : tasks) {
			LOGGER.debug("Execute task {}", task.getName());
			switch (task.getType()) {
			case REQUEST:
				Request requestTemplate = data.getRequests().get(task.getName());
				String request = requestBuilder.buildRequest(requestTemplate);
				String response = connector.makeRequest(request);
				break;
			}
		}
	}

	private Map<String, Parameter> mergeparameters(RestificatorExecutionData data, List<Parameter> readParameters) {
		Map<String, Parameter> mergedParameters = parametersMapper.mergeParameterLists(
				readParameters,
				data.getParameters().getPredefinedParameters()
				);
		return mergedParameters;
	}

	private List<Parameter> readParameters(RestificatorExecutionData data) {
		List<Parameter> readParameters = parametersScanner
				.readParameters(data.getParameters().getInteractiveParameters());
		return readParameters;
	}
}

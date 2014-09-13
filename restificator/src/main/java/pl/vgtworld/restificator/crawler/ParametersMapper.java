package pl.vgtworld.restificator.crawler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.vgtworld.restificator.data.parameters.Parameter;

class ParametersMapper {
	
	Map<String, Parameter> mergeParameterLists(
			List<Parameter> interactiveParameters, List<Parameter> predefinedParameters) {
		Map<String, Parameter> result = new HashMap<>();
		for (Parameter parameter : interactiveParameters) {
			result.put(parameter.getName(), parameter);
		}
		for (Parameter parameter : predefinedParameters) {
			result.put(parameter.getName(), parameter);
		}
		return result;
	}
	
}

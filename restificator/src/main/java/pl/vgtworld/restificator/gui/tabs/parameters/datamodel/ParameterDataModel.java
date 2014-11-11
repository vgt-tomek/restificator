package pl.vgtworld.restificator.gui.tabs.parameters.datamodel;

import pl.vgtworld.restificator.data.parameters.Parameter;

public class ParameterDataModel {

	private Parameter parameter;

	private ParameterGroup group;

	public ParameterDataModel(Parameter parameter, ParameterGroup group) {
		this.parameter = parameter;
		this.group = group;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public ParameterGroup getGroup() {
		return group;
	}

}

package pl.vgtworld.restificator.data.parameters;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parameters {
	
	@XmlElementWrapper(name = "interactive")
	@XmlElements({
			@XmlElement(name = "text", type = Text.class),
			@XmlElement(name = "counter", type = Counter.class),
			@XmlElement(name = "datetime", type = Datetime.class)
	})
	private List<Parameter> interactiveParameters;
	
	@XmlElementWrapper(name = "predefined")
	@XmlElements({
			@XmlElement(name = "text", type = Text.class),
			@XmlElement(name = "counter", type = Counter.class),
			@XmlElement(name = "datetime", type = Datetime.class)
	})
	private List<Parameter> predefinedParameters;
	
	public List<Parameter> getInteractiveParameters() {
		return interactiveParameters;
	}
	
	public void setInteractiveParameters(List<Parameter> interactiveParameters) {
		this.interactiveParameters = interactiveParameters;
	}
	
	public List<Parameter> getPredefinedParameters() {
		return predefinedParameters;
	}
	
	public void setPredefinedParameters(List<Parameter> predefinedParameters) {
		this.predefinedParameters = predefinedParameters;
	}
	
	@Override
	public String toString() {
		return "Parameters [interactiveParameters=" + interactiveParameters + ", predefinedParameters="
				+ predefinedParameters + "]";
	}
	
}

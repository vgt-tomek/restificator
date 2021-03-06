package pl.vgtworld.restificator.data.parameters;

public abstract class Parameter {
	
	private String name;
	
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract String getParameterValue();
	
}

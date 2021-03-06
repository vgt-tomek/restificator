package pl.vgtworld.restificator.data.parameters;

public class Text extends Parameter {
	
	private String value;
	
	public Text() {
	}
	
	public Text(String name, String value) {
		setName(name);
		setValue(value);
	}
	
	@Override
	public String getParameterValue() {
		return value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Text [name=" + getName() + ", value=" + value + "]";
	}
	
}

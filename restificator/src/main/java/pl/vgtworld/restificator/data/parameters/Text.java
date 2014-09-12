package pl.vgtworld.restificator.data.parameters;

public class Text extends Parameter {
	
	private String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String getValue() {
		return text;
	}
	
	@Override
	public String toString() {
		return "Text [name=" + getName() + ", text=" + text + "]";
	}
	
}

package pl.vgtworld.restificator.data.parameters;

public class Counter extends Parameter {
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String getParameterValue() {
		return "" + (value++);
	}
	
	@Override
	public String toString() {
		return "Counter [name=" + getName() + ", value=" + value + "]";
	}
	
}

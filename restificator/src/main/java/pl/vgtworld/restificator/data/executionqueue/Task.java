package pl.vgtworld.restificator.data.executionqueue;

public class Task {
	
	private TaskType type;
	
	private String name;
	
	public TaskType getType() {
		return type;
	}
	
	public void setType(TaskType type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Task [type=" + type + ", name=" + name + "]";
	}
	
}

package pl.vgtworld.restificator.validator;

import java.util.List;
import java.util.Map;

import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.requests.Request;

class TasksValidator {
	
	enum ErrorMessages {
		
		TASKS_REQUIRED("Task node is required."),
		TASK_COUNT("No tasks defined. At least one task should be created."),
		TASK_TYPE_REQUIRED("Task type is missing or invalid value is used in one of the tasks."),
		TASK_NAME_REQUIRED("Task name is missing in one of the tasks."),
		REQUEST_MISSING("Request with name '%s' defined in task is missing.");
		
		private String message;
		
		String getMessage() {
			return message;
		}
		
		private ErrorMessages(String message) {
			this.message = message;
		}
	}
	
	void validate(List<Task> tasks, Map<String, Request> requests) throws XmlValidationException {
		if (tasks == null) {
			throw new XmlValidationException(ErrorMessages.TASKS_REQUIRED.getMessage());
		}
		if (tasks.size() == 0) {
			throw new XmlValidationException(ErrorMessages.TASK_COUNT.getMessage());
		}
		for (Task task : tasks) {
			validateTask(task, requests);
		}
	}
	
	private void validateTask(Task task, Map<String, Request> requests) throws XmlValidationException {
		if (task.getType() == null) {
			throw new XmlValidationException(ErrorMessages.TASK_TYPE_REQUIRED.getMessage());
		}
		if (task.getName() == null) {
			throw new XmlValidationException(ErrorMessages.TASK_NAME_REQUIRED.getMessage());
		}
		switch (task.getType()) {
		case REQUEST:
			String requestName = task.getName();
			if (!requests.containsKey(requestName)) {
				String message = String.format(ErrorMessages.REQUEST_MISSING.getMessage(), requestName);
				throw new XmlValidationException(message);
			}
			break;
		}
	}
}

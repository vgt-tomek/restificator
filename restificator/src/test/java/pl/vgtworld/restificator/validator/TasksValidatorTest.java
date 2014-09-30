package pl.vgtworld.restificator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.executionqueue.TaskType;
import pl.vgtworld.restificator.data.requests.Request;

public class TasksValidatorTest {
	
	private static final String REQUEST_NAME = "example-request";
	
	private TasksValidator validator = new TasksValidator();
	
	@Test
	public void shouldThrowExceptionWhenTasksNodeIsMissing() {
		String expectedErrorMessage = TasksValidator.ErrorMessages.TASKS_REQUIRED.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(null, createRequestsMap());
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTaskListIsEmpty() {
		String expectedErrorMessage = TasksValidator.ErrorMessages.TASK_COUNT.getMessage();
		String errorMessage = null;
		
		try {
			validator.validate(new ArrayList<Task>(), createRequestsMap());
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTaskTypeIsMissing() {
		String expectedErrorMessage = TasksValidator.ErrorMessages.TASK_TYPE_REQUIRED.getMessage();
		String errorMessage = null;
		Task task = new Task();
		task.setName(REQUEST_NAME);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		
		try {
			validator.validate(tasks, createRequestsMap());
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenTaskNameIsMissing() {
		String expectedErrorMessage = TasksValidator.ErrorMessages.TASK_NAME_REQUIRED.getMessage();
		String errorMessage = null;
		Task task = new Task();
		task.setType(TaskType.REQUEST);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		
		try {
			validator.validate(tasks, createRequestsMap());
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldThrowExceptionWhenRequestWithDefinedNameDoesNotExist() {
		String missingRequestName = "other-request";
		String expectedErrorMessage = String.format(
				TasksValidator.ErrorMessages.REQUEST_MISSING.getMessage(),
				missingRequestName
				);
		String errorMessage = null;
		Task task = new Task();
		task.setType(TaskType.REQUEST);
		task.setName(missingRequestName);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		
		try {
			validator.validate(tasks, createRequestsMap());
		} catch (XmlValidationException e) {
			errorMessage = e.getMessage();
		}
		
		assertThat(errorMessage).isEqualTo(expectedErrorMessage);
	}
	
	@Test
	public void shouldAcceptValidTaskList() throws XmlValidationException {
		validator.validate(createValidTaskList(), createRequestsMap());
	}
	
	private List<Task> createValidTaskList() {
		List<Task> list = new ArrayList<>();
		Task task = new Task();
		task.setType(TaskType.REQUEST);
		task.setName(REQUEST_NAME);
		list.add(task);
		return list;
	}
	
	private Map<String, Request> createRequestsMap() {
		Map<String, Request> map = new HashMap<>();
		map.put(REQUEST_NAME, RequestsFactory.getNewInstance());
		return map;
	}
}

package pl.vgtworld.restificator.gui.services;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.parameters.Parameters;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.data.settings.Settings;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;

@Singleton
public class DataService {

	private RestificatorExecutionData data;

	public void cleanData() {
		data = new RestificatorExecutionData();
		data.setSettings(new Settings());
		data.setGlobalHeaders(new ArrayList<Header>());
		data.setParameters(new Parameters());
		data.setTasks(new ArrayList<Task>());
		data.setRequests(new HashMap<String, Request>());
	}
}

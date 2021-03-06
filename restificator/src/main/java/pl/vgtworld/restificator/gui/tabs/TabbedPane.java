package pl.vgtworld.restificator.gui.tabs;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.tabs.globalheaders.GlobalHeadersPanel;
import pl.vgtworld.restificator.gui.tabs.parameters.ParametersPanel;
import pl.vgtworld.restificator.gui.tabs.requests.RequestsPanel;
import pl.vgtworld.restificator.gui.tabs.settings.SettingsPanel;
import pl.vgtworld.restificator.gui.tabs.tasks.TasksPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JTabbedPane;

@Singleton
public class TabbedPane extends JTabbedPane {

	@Inject
	private SettingsPanel settings;

	@Inject
	private GlobalHeadersPanel globalHeaders;

	@Inject
	private ParametersPanel parametersPanel;

	@Inject
	private TasksPanel tasksPanel;

	@Inject
	private RequestsPanel requestsPanel;

	@PostConstruct
	private void buildGui() {
		addTab("Settings", settings);
		addTab("Global headers", globalHeaders);
		addTab("Parameters", parametersPanel);
		addTab("Tasks", tasksPanel);
		addTab("Requests", requestsPanel);
	}

	public void cleanData() {
		settings.cleanData();
		globalHeaders.cleanData();
		parametersPanel.cleanData();
		tasksPanel.cleanData();
		requestsPanel.cleanData();
	}

	public void fillWithData(RestificatorExecutionData data) {
		settings.fillWithData(data.getSettings());
		globalHeaders.fillWithData(data.getGlobalHeaders());
		parametersPanel.fillWithData(data.getParameters());
		tasksPanel.fillWithData(data.getTasks());
		requestsPanel.fillWithData(data.getRequests());
	}

	public RestificatorExecutionData readData() {
		RestificatorExecutionData data = new RestificatorExecutionData();
		data.setSettings(settings.readData());
		data.setGlobalHeaders(globalHeaders.readData());
		data.setParameters(parametersPanel.readData());
		data.setTasks(tasksPanel.readData());
		data.setRequests(requestsPanel.readData());
		return data;
	}

}

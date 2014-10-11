package pl.vgtworld.restificator.gui.tabs;

import pl.vgtworld.restificator.gui.tabs.settings.SettingsPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JTabbedPane;

@Singleton
public class TabbedPane extends JTabbedPane {

	@Inject
	private SettingsPanel settings;

	@PostConstruct
	private void buildGui() {
		addTab("Settings", settings);
		addTab("Global headers", null);
		addTab("Parameters", null);
		addTab("Tasks", null);
		addTab("Requests", null);
	}
}

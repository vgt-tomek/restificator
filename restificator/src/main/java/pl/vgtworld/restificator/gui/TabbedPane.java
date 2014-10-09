package pl.vgtworld.restificator.gui;

import javax.inject.Singleton;
import javax.swing.JTabbedPane;

@Singleton
public class TabbedPane extends JTabbedPane {

	public TabbedPane() {
		buildGui();
	}

	private void buildGui() {
		addTab("Settings", null);
		addTab("Global headers", null);
		addTab("Parameters", null);
		addTab("Tasks", null);
		addTab("Requests", null);
	}
}

package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
public class SaveFileAction extends AbstractAction {

	@Inject
	private TabbedPane pane;

	@PostConstruct
	private void init() {
		putValue(NAME, "Save");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RestificatorExecutionData data = pane.readData();
		//TODO Save data to xml file.
	}

}

package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.gui.services.DataService;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
public class NewFileAction extends AbstractAction {

	@Inject
	private TabbedPane tabbedPane;

	@Inject
	DataService data;

	@PostConstruct
	private void init() {
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		data.cleanData();
		tabbedPane.cleanData();
	}

}

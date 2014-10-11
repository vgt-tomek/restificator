package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.gui.tabs.TabbedPane;
import pl.vgtworld.restificator.service.CdiTestService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
public class NewFileAction extends AbstractAction {

	@Inject
	private CdiTestService testService;

	@Inject
	private TabbedPane tabbedPane;

	@PostConstruct
	private void init() {
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		testService.doSomething();
		tabbedPane.setEnabled(!tabbedPane.isEnabled());
	}

}

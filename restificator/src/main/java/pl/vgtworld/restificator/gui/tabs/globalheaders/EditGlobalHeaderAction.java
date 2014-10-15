package pl.vgtworld.restificator.gui.tabs.globalheaders;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
class EditGlobalHeaderAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO Missing implementation.
	}

	@PostConstruct
	private void init() {
		putValue(NAME, "Edit");
	}

}

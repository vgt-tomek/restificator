package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.gui.MainWindow;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Singleton
public class NewFileAction extends AbstractAction {

	@Inject
	private TabbedPane tabbedPane;

	@Inject
	private Provider<MainWindow> mainWindowProvider;

	@PostConstruct
	private void init() {
		putValue(NAME, "New");
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tabbedPane.cleanData();
		mainWindowProvider.get().setEditedFile(null);
	}

}

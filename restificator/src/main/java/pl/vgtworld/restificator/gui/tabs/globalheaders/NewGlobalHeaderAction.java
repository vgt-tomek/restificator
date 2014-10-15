package pl.vgtworld.restificator.gui.tabs.globalheaders;

import pl.vgtworld.restificator.gui.MainWindow;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
class NewGlobalHeaderAction extends AbstractAction {

	@Inject
	private Provider<MainWindow> mainWindow;

	@Inject
	private TableModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		GlobalHeaderFormDialog dialog = new GlobalHeaderFormDialog(mainWindow.get());
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			model.addRow(dialog.getName(), dialog.getValue());
		}
		dialog.dispose();
	}

	@PostConstruct
	private void init() {
		putValue(NAME, "New");
	}
}

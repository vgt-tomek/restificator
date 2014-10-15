package pl.vgtworld.restificator.gui.tabs.globalheaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.gui.MainWindow;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
class EditGlobalHeaderAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditGlobalHeaderAction.class);

	@Inject
	private Provider<MainWindow> mainWindow;

	@Inject
	private Provider<GlobalHeadersPanel> globalHeadersPanel;

	@Inject
	private TableModel model;

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = globalHeadersPanel.get().getSelectedRows();
		if (selectedRows.length != 1) {
			LOGGER.warn("Only one row should be selected. Currently selected rows: {}", selectedRows.length);
			return;
		}
		int index = selectedRows[0];
		Header row = globalHeadersPanel.get().getRow(index);
		GlobalHeaderFormDialog dialog = new GlobalHeaderFormDialog(mainWindow.get(), row.getName(), row.getValue());
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			Header header = new Header();
			header.setName(dialog.getName());
			header.setValue(dialog.getValue());
			globalHeadersPanel.get().updateRow(index, header);
		}
		dialog.dispose();
	}

	@PostConstruct
	private void init() {
		putValue(NAME, "Edit");
	}

}

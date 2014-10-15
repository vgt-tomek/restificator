package pl.vgtworld.restificator.gui.tabs.globalheaders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

@Singleton
class DeleteGlobalHeadersAction extends AbstractAction {

	@Inject
	private Provider<GlobalHeadersPanel> headersPanelProvider;

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = headersPanelProvider.get().getSelectedRows();
		for (int i = selectedRows.length - 1; i >= 0; --i) {
			headersPanelProvider.get().deleteRow(selectedRows[i]);
		}
	}

	@PostConstruct
	private void init() {
		putValue(NAME, "Delete");
	}
}

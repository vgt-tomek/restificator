package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

class DeleteHeadersAction extends AbstractAction {

	private HeadersPanel headersPanel;

	DeleteHeadersAction(HeadersPanel headersPanel) {
		this.headersPanel = headersPanel;
		putValue(NAME, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = headersPanel.getSelectedRows();
		for (int i = selectedRows.length - 1; i >= 0; --i) {
			headersPanel.deleteRow(selectedRows[i]);
		}
	}

}

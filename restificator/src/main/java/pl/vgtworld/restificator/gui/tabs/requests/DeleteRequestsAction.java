package pl.vgtworld.restificator.gui.tabs.requests;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

class DeleteRequestsAction extends AbstractAction {

	private RequestsPanel requestsPanel;

	DeleteRequestsAction(RequestsPanel requestsPanel) {
		this.requestsPanel = requestsPanel;
		putValue(NAME, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = requestsPanel.getSelectedRows();
		for (int i = selectedRows.length - 1; i >= 0; --i) {
			requestsPanel.deleteRow(selectedRows[i]);
		}
	}

}

package pl.vgtworld.restificator.gui.tabs.requests;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SelectionListener implements ListSelectionListener {

	private RequestsPanel requestsPanel;

	private ButtonBar buttonBar;

	SelectionListener(RequestsPanel requestsPanel, ButtonBar buttonBar) {
		this.requestsPanel = requestsPanel;
		this.buttonBar = buttonBar;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = requestsPanel.getSelectedRows();
		buttonBar.setEnabledEditButton(selectedRows.length == 1);
		buttonBar.setEnabledDeleteButton(selectedRows.length > 0);
	}

}

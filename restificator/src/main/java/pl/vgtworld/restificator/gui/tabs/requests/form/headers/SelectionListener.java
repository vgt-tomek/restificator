package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SelectionListener implements ListSelectionListener {

	private HeadersPanel headersPanel;

	private ButtonBar buttonBar;

	SelectionListener(HeadersPanel headersPanel, ButtonBar buttonBar) {
		this.headersPanel = headersPanel;
		this.buttonBar = buttonBar;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = headersPanel.getSelectedRows();
		buttonBar.setEnabledEditButton(selectedRows.length == 1);
		buttonBar.setEnabledDeleteButton(selectedRows.length > 0);
	}

}

package pl.vgtworld.restificator.gui.tabs.globalheaders;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SelectionListener implements ListSelectionListener {

	private GlobalHeadersPanel headersPanel;

	private ButtonBar buttonBar;

	SelectionListener(GlobalHeadersPanel headersPanel, ButtonBar buttonBar) {
		this.headersPanel = headersPanel;
		this.buttonBar = buttonBar;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = headersPanel.getSelectedRows();
		buttonBar.setEnabledDeleteButton(selectedRows.length > 0);
	}

}

package pl.vgtworld.restificator.gui.tabs.parameters;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SelectionListener implements ListSelectionListener {

	private ParametersPanel parametersPanel;

	private ButtonBar buttonBar;

	SelectionListener(ParametersPanel parametersPanel, ButtonBar buttonBar) {
		this.parametersPanel = parametersPanel;
		this.buttonBar = buttonBar;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = parametersPanel.getSelectedRows();
		buttonBar.setEnabledEditButton(selectedRows.length == 1);
		buttonBar.setEnabledDeleteButton(selectedRows.length > 0);
	}
}

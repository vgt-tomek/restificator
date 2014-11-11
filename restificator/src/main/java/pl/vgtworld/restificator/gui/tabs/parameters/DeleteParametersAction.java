package pl.vgtworld.restificator.gui.tabs.parameters;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

class DeleteParametersAction extends AbstractAction {

	private ParametersPanel parametersPanel;

	DeleteParametersAction(ParametersPanel parametersPanel) {
		this.parametersPanel = parametersPanel;
		putValue(NAME, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = parametersPanel.getSelectedRows();
		for (int i = selectedRows.length - 1; i >= 0; --i) {
			parametersPanel.deleteRow(selectedRows[i]);
		}
	}
}

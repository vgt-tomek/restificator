package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.gui.tabs.requests.form.RequestsFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewRequestAction extends AbstractAction {

	private JFrame mainWindow;

	private TableModel tableModel;

	NewRequestAction(JFrame owner, TableModel tableModel) {
		this.mainWindow = owner;
		this.tableModel = tableModel;
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RequestsFormDialog dialog = new RequestsFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			tableModel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}

}

package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.gui.tabs.requests.form.RequestsFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewRequestAction extends AbstractAction {

	private JFrame mainWindow;

	private RequestsPanel requestsPanel;

	NewRequestAction(JFrame owner, RequestsPanel requestsPanel) {
		this.mainWindow = owner;
		this.requestsPanel = requestsPanel;
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RequestsFormDialog dialog = new RequestsFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			requestsPanel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}

}

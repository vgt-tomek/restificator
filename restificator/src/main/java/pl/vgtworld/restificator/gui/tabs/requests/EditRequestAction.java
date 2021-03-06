package pl.vgtworld.restificator.gui.tabs.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.gui.tabs.requests.form.RequestsFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class EditRequestAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditRequestAction.class);

	private JFrame owner;

	private RequestsPanel requestsPanel;

	EditRequestAction(JFrame owner, RequestsPanel requestsPanel) {
		this.owner = owner;
		this.requestsPanel = requestsPanel;
		putValue(NAME, "Edit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = requestsPanel.getSelectedRows();
		if (selectedRows.length != 1) {
			LOGGER.warn("Only one row should be selected. Currently selected rows: {}", selectedRows.length);
			return;
		}
		int index = selectedRows[0];
		RequestDataModel row = requestsPanel.getRow(index);
		RequestsFormDialog dialog = new RequestsFormDialog(owner, row);
		dialog.setLocationRelativeTo(owner);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			requestsPanel.updateRow(index, dialog.getFilledData());
		}
		dialog.dispose();
	}

}

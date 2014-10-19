package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.gui.components.HeaderFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class EditHeaderAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditHeaderAction.class);

	private JFrame owner;

	private HeadersPanel headersPanel;

	EditHeaderAction(JFrame owner, HeadersPanel headersPanel) {
		this.owner = owner;
		this.headersPanel = headersPanel;
		putValue(NAME, "Edit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = headersPanel.getSelectedRows();
		if (selectedRows.length != 1) {
			LOGGER.warn("Only one row should be selected. Currently selected rows: {}", selectedRows.length);
			return;
		}
		int index = selectedRows[0];
		Header row = headersPanel.getRow(index);
		HeaderFormDialog dialog = new HeaderFormDialog(owner, row.getName(), row.getValue());
		dialog.setLocationRelativeTo(owner);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			Header header = new Header();
			header.setName(dialog.getName());
			header.setValue(dialog.getValue());
			headersPanel.updateRow(index, header);
		}
		dialog.dispose();
		//TODO Implementation.
	}

}

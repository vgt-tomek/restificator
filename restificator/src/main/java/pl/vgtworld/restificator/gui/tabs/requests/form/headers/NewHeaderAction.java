package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.gui.components.HeaderFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewHeaderAction extends AbstractAction{

	private JFrame owner;

	private TableModel tableModel;

	NewHeaderAction(JFrame owner, TableModel tableModel) {
		this.owner = owner;
		this.tableModel = tableModel;
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HeaderFormDialog dialog = new HeaderFormDialog(owner);
		dialog.setLocationRelativeTo(owner);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			Header header = new Header();
			header.setName(dialog.getName());
			header.setValue(dialog.getValue());
			tableModel.addRow(header);
		}
		dialog.dispose();
	}

}

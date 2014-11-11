package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.gui.tabs.parameters.forms.datetime.DatetimeParameterFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewDatetimeAction extends AbstractAction {

	private JFrame mainWindow;

	private ParametersPanel parametersPanel;

	NewDatetimeAction(JFrame mainWindow, ParametersPanel parametersPanel) {
		this.mainWindow = mainWindow;
		this.parametersPanel = parametersPanel;
		putValue(NAME, "New datetime");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DatetimeParameterFormDialog dialog = new DatetimeParameterFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}
}

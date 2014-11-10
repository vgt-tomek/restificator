package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.gui.tabs.parameters.forms.text.TextParameterFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewTextAction extends AbstractAction {

	private JFrame mainWindow;

	private ParametersPanel parametersPanel;

	NewTextAction(JFrame mainWindow, ParametersPanel parametersPanel) {
		this.mainWindow = mainWindow;
		this.parametersPanel = parametersPanel;
		putValue(NAME, "New text");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TextParameterFormDialog dialog = new TextParameterFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}
}

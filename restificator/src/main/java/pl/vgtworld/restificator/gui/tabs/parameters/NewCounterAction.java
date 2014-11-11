package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.gui.tabs.parameters.forms.counter.CounterParameterFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewCounterAction extends AbstractAction {

	private JFrame mainWindow;

	private ParametersPanel parametersPanel;

	NewCounterAction(JFrame mainWindow, ParametersPanel parametersPanel) {
		this.mainWindow = mainWindow;
		this.parametersPanel = parametersPanel;
		putValue(NAME, "New counter");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CounterParameterFormDialog dialog = new CounterParameterFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}
}

package pl.vgtworld.restificator.gui.tabs.parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.parameters.Counter;
import pl.vgtworld.restificator.data.parameters.Datetime;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Text;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;
import pl.vgtworld.restificator.gui.tabs.parameters.forms.counter.CounterParameterFormDialog;
import pl.vgtworld.restificator.gui.tabs.parameters.forms.datetime.DatetimeParameterFormDialog;
import pl.vgtworld.restificator.gui.tabs.parameters.forms.text.TextParameterFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class EditParameterAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditParameterAction.class);

	private JFrame mainWindow;

	private ParametersPanel parametersPanel;

	EditParameterAction(JFrame mainWindow, ParametersPanel parametersPanel) {
		this.mainWindow = mainWindow;
		this.parametersPanel = parametersPanel;
		putValue(NAME, "Edit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = parametersPanel.getSelectedRows();
		if (selectedRows.length != 1) {
			LOGGER.warn("Only one row should be selected. Currently selected rows: {}", selectedRows.length);
			return;
		}
		int index = selectedRows[0];
		ParameterDataModel row = parametersPanel.getRow(index);
		Parameter parameter = row.getParameter();
		if (parameter instanceof Text) {
			updateTextParameter(index, row);
		}
		if (parameter instanceof Counter) {
			updateCounterParameter(index, row);
		}
		if (parameter instanceof Datetime) {
			updateDatetimeParameter(index, row);
		}
	}

	private void updateTextParameter(int index, ParameterDataModel row) {
		TextParameterFormDialog dialog = new TextParameterFormDialog(mainWindow, row);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.updateRow(index, dialog.getFilledData());
		}
		dialog.dispose();
	}

	private void updateCounterParameter(int index, ParameterDataModel row) {
		CounterParameterFormDialog dialog = new CounterParameterFormDialog(mainWindow, row);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.updateRow(index, dialog.getFilledData());
		}
		dialog.dispose();
	}

	private void updateDatetimeParameter(int index, ParameterDataModel row) {
		DatetimeParameterFormDialog dialog = new DatetimeParameterFormDialog(mainWindow, row);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			parametersPanel.updateRow(index, dialog.getFilledData());
		}
		dialog.dispose();
	}
}

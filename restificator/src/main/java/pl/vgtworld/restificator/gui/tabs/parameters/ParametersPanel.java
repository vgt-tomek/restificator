package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Parameters;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterGroup;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ParametersPanel extends JPanel {

	private TableModel tableModel;

	private JTable table;

	private ButtonBar buttonBar;

	public void cleanData() {
		tableModel.clearData();
		buttonBar.setEnabledEditButton(false);
		buttonBar.setEnabledDeleteButton(false);
	}

	public void fillWithData(Parameters parameters) {
		tableModel.clearData();
		if (parameters.getInteractiveParameters() != null) {
			for (Parameter parameter : parameters.getInteractiveParameters()) {
				tableModel.addRow(new ParameterDataModel(parameter, ParameterGroup.INTERACTIVE));
			}
		}
		if (parameters.getPredefinedParameters() != null) {
			for (Parameter parameter : parameters.getPredefinedParameters()) {
				tableModel.addRow(new ParameterDataModel(parameter, ParameterGroup.PREDEFINED));
			}
		}
	}

	public Parameters readData() {
		List<Parameter> interactiveParameters = new ArrayList<>();
		List<Parameter> predefinedParameters = new ArrayList<>();
		List<ParameterDataModel> tableRows = tableModel.readRows();
		for (ParameterDataModel parameter : tableRows) {
			switch (parameter.getGroup()) {
				case INTERACTIVE:
					interactiveParameters.add(parameter.getParameter());
					break;
				case PREDEFINED:
					predefinedParameters.add(parameter.getParameter());
					break;
			}
		}
		Parameters parameters = new Parameters();
		parameters.setInteractiveParameters(interactiveParameters);
		parameters.setPredefinedParameters(predefinedParameters);
		return parameters;
	}

	public void addRow(ParameterDataModel row) {
		tableModel.addRow(row);
	}

	public int[] getSelectedRows() {
		return table.getSelectedRows();
	}

	public ParameterDataModel getRow(int index) {
		return tableModel.getRow(index);
	}

	public void updateRow(int index, ParameterDataModel row) {
		tableModel.updateRow(index, row);
	}

	public void deleteRow(int index) {
		tableModel.deleteRow(index);
		table.getSelectionModel().clearSelection();
	}

	@PostConstruct
	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		JFrame mainWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
		NewDatetimeAction newDatetimeAction = new NewDatetimeAction(mainWindow, this);
		NewTextAction newTextAction = new NewTextAction(mainWindow, this);
		NewCounterAction newCounterAction = new NewCounterAction(mainWindow, this);
		EditParameterAction editParameterAction = new EditParameterAction(mainWindow, this);
		DeleteParametersAction deleteParametersAction = new DeleteParametersAction(this);
		buttonBar = new ButtonBar(newDatetimeAction, newTextAction, newCounterAction, editParameterAction, deleteParametersAction);
		SelectionListener selectionListener = new SelectionListener(this, buttonBar);
		table.getSelectionModel().addListSelectionListener(selectionListener);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

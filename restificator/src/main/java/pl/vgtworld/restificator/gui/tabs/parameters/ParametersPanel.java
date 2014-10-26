package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Parameters;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

@Singleton
public class ParametersPanel extends JPanel {

	private TableModel tableModel;

	private JTable table;

	private ButtonBar buttonBar;

	public void cleanData() {
		//TODO Implementaion.
	}

	public void fillWithData(Parameters parameters) {
		tableModel.clearData();
		if (parameters.getInteractiveParameters() != null) {
			for (Parameter parameter : parameters.getInteractiveParameters()) {
				tableModel.addRow(parameter);
			}
		}
		if (parameters.getPredefinedParameters() != null) {
			for (Parameter parameter : parameters.getPredefinedParameters()) {
				tableModel.addRow(parameter);
			}
		}
	}

	public Parameters readData() {
		//TODO Implementaion.
		return new Parameters();
	}

	@PostConstruct
	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		NewDatetimeAction newDatetimeAction = new NewDatetimeAction();
		NewTextAction newTextAction = new NewTextAction();
		NewCounterAction newCounterAction = new NewCounterAction();
		EditParameterAction editParameterAction = new EditParameterAction();
		DeleteParametersAction deleteParametersAction = new DeleteParametersAction();
		buttonBar = new ButtonBar(newDatetimeAction, newTextAction, newCounterAction, editParameterAction, deleteParametersAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

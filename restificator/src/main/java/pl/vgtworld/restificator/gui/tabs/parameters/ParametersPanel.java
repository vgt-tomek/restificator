package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.data.parameters.Parameters;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JPanel;
import java.awt.BorderLayout;

@Singleton
public class ParametersPanel extends JPanel {

	private ButtonBar buttonBar;

	@PostConstruct
	private void init() {
		NewDatetimeAction newDatetimeAction = new NewDatetimeAction();
		NewTextAction newTextAction = new NewTextAction();
		NewCounterAction newCounterAction = new NewCounterAction();
		EditParameterAction editParameterAction = new EditParameterAction();
		DeleteParametersAction deleteParametersAction = new DeleteParametersAction();
		buttonBar = new ButtonBar(newDatetimeAction, newTextAction, newCounterAction, editParameterAction, deleteParametersAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
	}

	public void cleanData() {
		//TODO Implementaion.
	}

	public void fillWithData(Parameters parameters) {
		//TODO Implementaion.
	}

	public Parameters readData() {
		//TODO Implementaion.
		return new Parameters();
	}
}

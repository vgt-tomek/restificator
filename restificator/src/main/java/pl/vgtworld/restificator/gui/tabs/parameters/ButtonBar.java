package pl.vgtworld.restificator.gui.tabs.parameters;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

class ButtonBar extends JPanel {

	private Action newDatetimeActon;

	private Action newTextAction;

	private Action newCounterAction;

	private Action editParameterAction;

	private Action deleteParametersAction;

	private JButton newDatetimeButton;

	private JButton newTextButton;

	private JButton newCounterButton;

	private JButton editParameterButton;

	private JButton deleteParametersButton;

	ButtonBar(Action newDatetimeActon, Action newTextAction, Action newCounterAction, Action editParameterAction, Action deleteParametersAction) {
		this.newDatetimeActon = newDatetimeActon;
		this.newTextAction = newTextAction;
		this.newCounterAction = newCounterAction;
		this.editParameterAction = editParameterAction;
		this.deleteParametersAction = deleteParametersAction;
		init();
	}

	void setEnabledEditButton(boolean state) {
		editParameterButton.setEnabled(state);
	}

	void setEnabledDeleteButton(boolean state) {
		deleteParametersButton.setEnabled(state);
	}

	private void init() {
		newDatetimeButton = new JButton(newDatetimeActon);
		newTextButton = new JButton(newTextAction);
		newCounterButton = new JButton(newCounterAction);
		editParameterButton = new JButton(editParameterAction);
		deleteParametersButton = new JButton(deleteParametersAction);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		editParameterButton.setEnabled(false);
		deleteParametersButton.setEnabled(false);

		add(newDatetimeButton);
		add(newTextButton);
		add(newCounterButton);
		add(editParameterButton);
		add(deleteParametersButton);
	}
}

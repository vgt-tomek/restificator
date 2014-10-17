package pl.vgtworld.restificator.gui.tabs.requests;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

class ButtonBar extends JPanel {

	private Action newRequestAction;

	private Action editRequestAction;

	private Action deleteRequestsAction;

	private JButton newRequestButton;

	private JButton editRequestButton;

	private JButton deleteRequestsButton;

	ButtonBar(Action newRequestAction, Action editRequestAction, Action deleteRequestsAction) {
		this.newRequestAction = newRequestAction;
		this.editRequestAction = editRequestAction;
		this.deleteRequestsAction = deleteRequestsAction;
		init();
	}

	void setEnabledEditButton(boolean state) {
		editRequestButton.setEnabled(state);
	}

	void setEnabledDeleteButton(boolean state) {
		deleteRequestsButton.setEnabled(state);
	}

	private void init() {
		newRequestButton = new JButton(newRequestAction);
		editRequestButton = new JButton(editRequestAction);
		deleteRequestsButton = new JButton(deleteRequestsAction);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		editRequestButton.setEnabled(false);
		deleteRequestsButton.setEnabled(false);

		add(newRequestButton);
		add(editRequestButton);
		add(deleteRequestsButton);
	}

}

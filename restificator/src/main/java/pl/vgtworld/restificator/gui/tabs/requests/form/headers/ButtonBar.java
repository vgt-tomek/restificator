package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

class ButtonBar extends JPanel {

	private Action newHeaderAction;

	private Action editHeaderAction;

	private Action deleteHeaadersAction;

	private JButton newHeaderButton;

	private JButton editHeaderButton;

	private JButton deleteHeadersButton;

	ButtonBar(Action newHeaderAction, Action editHeaderAction, Action deleteHeaadersAction) {
		this.newHeaderAction = newHeaderAction;
		this.editHeaderAction = editHeaderAction;
		this.deleteHeaadersAction = deleteHeaadersAction;
		init();
	}

	void setEnabledEditButton(boolean state) {
		editHeaderButton.setEnabled(state);
	}

	void setEnabledDeleteButton(boolean state) {
		deleteHeadersButton.setEnabled(state);
	}

	private void init() {
		newHeaderButton = new JButton(newHeaderAction);
		editHeaderButton = new JButton(editHeaderAction);
		deleteHeadersButton = new JButton(deleteHeaadersAction);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		editHeaderButton.setEnabled(false);
		deleteHeadersButton.setEnabled(false);

		add(newHeaderButton);
		add(editHeaderButton);
		add(deleteHeadersButton);
	}

}

package pl.vgtworld.restificator.gui.tabs.globalheaders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

@Singleton
class ButtonBar extends JPanel {

	@Inject
	private NewGlobalHeaderAction newHeaderAction;

	@Inject
	private DeleteGlobalHeadersAction deleteHeadersAction;

	private JButton deleteHeadersButton;

	@Inject
	private EditGlobalHeaderAction editHeaderAction;

	private JButton editHeaderButton;

	void setEnabledDeleteButton(boolean state) {
		deleteHeadersButton.setEnabled(state);
	}

	void setEnabledEditButton(boolean state) {
		editHeaderButton.setEnabled(state);
	}

	@PostConstruct
	private void init() {
		deleteHeadersButton = new JButton(deleteHeadersAction);
		editHeaderButton = new JButton(editHeaderAction);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		deleteHeadersButton.setEnabled(false);
		editHeaderButton.setEnabled(false);

		add(new JButton(newHeaderAction));
		add(editHeaderButton);
		add(deleteHeadersButton);
	}
}

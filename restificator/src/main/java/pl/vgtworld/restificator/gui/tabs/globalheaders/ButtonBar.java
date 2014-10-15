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

	void setEnabledDeleteButton(boolean state) {
		deleteHeadersButton.setEnabled(state);
	}

	@PostConstruct
	private void init() {
		deleteHeadersButton = new JButton(deleteHeadersAction);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		deleteHeadersButton.setEnabled(false);

		add(new JButton(newHeaderAction));
		add(deleteHeadersButton);
	}
}

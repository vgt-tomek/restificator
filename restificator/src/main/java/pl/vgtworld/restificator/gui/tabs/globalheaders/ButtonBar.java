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

	@PostConstruct
	private void init() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JButton(newHeaderAction));
	}
}

package pl.vgtworld.restificator.gui;

import pl.vgtworld.restificator.gui.tabs.TabbedPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

@Singleton
public class MainWindow extends JFrame {

	@Inject
	private ButtonBar buttonBar;

	@Inject
	private TabbedPane tabbedPane;

	@PostConstruct
	private void init() {
		setTitle("Restificator");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buildGui();
	}

	private void buildGui() {
		setLayout(new BorderLayout());

		add(buttonBar, BorderLayout.PAGE_START);
		add(tabbedPane, BorderLayout.CENTER);
	}
}

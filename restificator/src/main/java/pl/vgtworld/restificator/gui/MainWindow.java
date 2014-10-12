package pl.vgtworld.restificator.gui;

import pl.vgtworld.restificator.gui.menu.RestificatorMenu;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

@Singleton
public class MainWindow extends JFrame {

	private static final String FRAME_TITLE = "Restificator";

	@Inject
	private ButtonBar buttonBar;

	@Inject
	private TabbedPane tabbedPane;

	@Inject
	private RestificatorMenu menu;

	private String editedFile;

	public String getEditedFile() {
		return editedFile;
	}

	public void setEditedFile(String file) {
		editedFile = file;
		if (file == null) {
			setTitle(FRAME_TITLE);
		} else {
			setTitle(String.format("%s - %s", FRAME_TITLE, editedFile));
		}
	}

	@PostConstruct
	private void init() {
		setTitle(FRAME_TITLE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setJMenuBar(menu);
		buildGui();
	}

	private void buildGui() {
		setLayout(new BorderLayout());

		add(buttonBar, BorderLayout.PAGE_START);
		add(tabbedPane, BorderLayout.CENTER);
	}
}

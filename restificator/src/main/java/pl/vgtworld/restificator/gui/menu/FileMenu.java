package pl.vgtworld.restificator.gui.menu;

import pl.vgtworld.restificator.gui.actions.LoadFileAction;
import pl.vgtworld.restificator.gui.actions.NewFileAction;
import pl.vgtworld.restificator.gui.actions.SaveFileAction;
import pl.vgtworld.restificator.gui.actions.SaveFileAsAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@Singleton
public class FileMenu extends JMenu {

	@Inject
	private NewFileAction newFileAction;

	@Inject
	private LoadFileAction loadFileAction;

	@Inject
	private SaveFileAction saveFileAction;

	@Inject
	private SaveFileAsAction saveFileAsAction;

	@PostConstruct
	private void init() {
		setText("File");
		setMnemonic('f');
		add(new JMenuItem(newFileAction));
		add(new JMenuItem(loadFileAction));
		add(new JMenuItem(saveFileAction));
		add(new JMenuItem(saveFileAsAction));
	}
}

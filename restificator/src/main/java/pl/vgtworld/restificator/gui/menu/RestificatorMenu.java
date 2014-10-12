package pl.vgtworld.restificator.gui.menu;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JMenuBar;

@Singleton
public class RestificatorMenu extends JMenuBar {

	@Inject
	private FileMenu fileMenu;

	@PostConstruct
	private void init() {
		add(fileMenu);
	}
}

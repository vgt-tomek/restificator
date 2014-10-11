package pl.vgtworld.restificator.gui;

import pl.vgtworld.restificator.gui.actions.LoadFileAction;
import pl.vgtworld.restificator.gui.actions.NewFileAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

@Singleton
public class ButtonBar extends JPanel {

	@Inject
	private NewFileAction newFileAction;

	@Inject
	private LoadFileAction loadFileAction;

	private JButton saveButton = new JButton("Save");

	@PostConstruct
	private void buildGui() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JButton(newFileAction));
		add(new JButton(loadFileAction));
		add(saveButton);
	}
}

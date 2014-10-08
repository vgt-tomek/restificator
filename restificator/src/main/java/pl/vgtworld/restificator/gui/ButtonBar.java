package pl.vgtworld.restificator.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class ButtonBar extends JPanel {

	private JButton newButton = new JButton("New");

	private JButton loadButton = new JButton("Load");

	private JButton saveButton = new JButton("Save");

	public ButtonBar() {
		buildGui();
	}

	private void buildGui() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(newButton);
		add(loadButton);
		add(saveButton);
	}
}

package pl.vgtworld.restificator.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("Restificator");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		buildGui();
	}

	private void buildGui() {
		setLayout(new BorderLayout());

		add(new ButtonBar(), BorderLayout.PAGE_START);
	}
}

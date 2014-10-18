package pl.vgtworld.restificator.gui.tabs.requests.form;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class RequestsFormDialog extends JDialog {

	private LeftFormPanel leftPanel;

	private RightFormPanel rightPanel;

	public RequestsFormDialog(JFrame owner) {
		super(owner);
		leftPanel = new LeftFormPanel();
		rightPanel = new RightFormPanel();
		init();
		setSize(800,600);
	}

	private void init() {
		setLayout(new GridLayout(1, 2));

		add(leftPanel);
		add(rightPanel);
	}

}

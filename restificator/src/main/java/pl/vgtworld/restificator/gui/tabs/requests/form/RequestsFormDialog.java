package pl.vgtworld.restificator.gui.tabs.requests.form;

import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

public class RequestsFormDialog extends JDialog {

	private LeftFormPanel leftPanel;

	private RightFormPanel rightPanel;

	private boolean saved;

	public RequestsFormDialog(JFrame owner) {
		super(owner);
		leftPanel = new LeftFormPanel();
		rightPanel = new RightFormPanel();
		init();
		setSize(800,600);
	}

	public boolean isSaved() {
		return saved;
	}

	private void init() {
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();
		JButton saveButton = new JButton("Save");
		JButton cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();

		setLayout(new GridBagLayout());

		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 100).setInsets(0).setFill(Fill.BOTH);
		add(leftPanel, gbc);
		gbc.setGrid(1, 0).setGridSize(1, 1).setWeight(100, 100).setInsets(0).setFill(Fill.BOTH);
		add(rightPanel, gbc);
		gbc.setGrid(0, 1).setGridSize(2, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(buttonPanel, gbc);

		cancelButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = false;
				setVisible(false);
			}
		});
		saveButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = true;
				setVisible(false);
			}
		});
	}

}

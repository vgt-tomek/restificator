package pl.vgtworld.restificator.gui.components;

import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

public class HeaderFormDialog extends JDialog {

	private static final int TEXT_FIELD_SIZE = 20;

	private JTextField name = new JTextField(TEXT_FIELD_SIZE);

	private JTextField value = new JTextField(TEXT_FIELD_SIZE);

	private JButton saveButton = new JButton("Save");

	private JButton cancelButton = new JButton("Cancel");

	private boolean saved = false;

	public HeaderFormDialog(JFrame owner) {
		super(owner, true);
		init();
	}

	public HeaderFormDialog(JFrame owner, String name, String value) {
		super(owner, true);
		init();
		this.name.setText(name);
		this.value.setText(value);
	}

	public String getName() {
		return name.getText();
	}

	public String getValue() {
		return value.getText();
	}

	public boolean isSaved() {
		return saved;
	}

	private void init() {
		JLabel nameLabel = new JLabel("Name:", JLabel.CENTER);
		JLabel valueLabel = new JLabel("Value:", JLabel.CENTER);
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();
		setLayout(new GridBagLayout());

		gbc.setGrid(0, 0).setGridSize(2, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(nameLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(2, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(name, gbc);
		gbc.setGrid(0, 2).setGridSize(2, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(valueLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(2, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(value, gbc);
		gbc.setGrid(0, 4).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(saveButton, gbc);
		gbc.setGrid(1, 4).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(cancelButton, gbc);

		pack();
		setLocationRelativeTo(getOwner());

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

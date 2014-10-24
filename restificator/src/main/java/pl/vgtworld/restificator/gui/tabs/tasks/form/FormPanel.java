package pl.vgtworld.restificator.gui.tabs.tasks.form;

import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

class FormPanel extends JPanel {

	private static final int TEXT_FIELD_SIZE = 20;

	private JTextField name = new JTextField(TEXT_FIELD_SIZE);

	private JTextField type = new JTextField(TEXT_FIELD_SIZE);

	FormPanel() {
		init();
	}

	String getTaskName() {
		return name.getText();
	}

	void setTaskName(String taskName) {
		name.setText(taskName);
	}

	String getTaskType() {
		return type.getText();
	}

	void setTaskType(String taskType) {
		type.setText(taskType);
	}

	private void init() {
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();
		JLabel nameLabel = new JLabel("Name:");
		JLabel typeLabel = new JLabel("Type:");

		setLayout(new GridBagLayout());
		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(nameLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(name, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(typeLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(type, gbc);
	}

}

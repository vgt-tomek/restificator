package pl.vgtworld.restificator.gui.tabs.parameters.forms.text;

import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterGroup;
import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

class FormPanel extends JPanel {

	private static final int TEXT_FIELD_SIZE = 20;

	private JTextField name;

	private JTextField value;

	private JComboBox<ParameterGroup> group;

	FormPanel() {
		init();
	}

	String getParameterName() {
		return name.getText();
	}

	void setParameterName(String parameterName) {
		name.setText(parameterName);
	}

	String getParameterValue() {
		return value.getText();
	}

	void setParameterValue(String parameterValue) {
		value.setText(parameterValue);
	}

	ParameterGroup getParameterGroup() {
		return group.getItemAt(group.getSelectedIndex());
	}

	void setParameterGroup(ParameterGroup parameterGroup) {
		group.setSelectedItem(parameterGroup);
	}

	private void init() {
		name = new JTextField(TEXT_FIELD_SIZE);
		value = new JTextField(TEXT_FIELD_SIZE);
		group = new JComboBox<>(ParameterGroup.values());
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();
		JLabel nameLabel = new JLabel("Name:");
		JLabel valueLabel = new JLabel("Value:");
		JLabel groupLabel = new JLabel("Group:");

		setLayout(new GridBagLayout());
		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(nameLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(name, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(valueLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(value, gbc);
		gbc.setGrid(0, 4).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(groupLabel, gbc);
		gbc.setGrid(0, 5).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(group, gbc);
	}
}

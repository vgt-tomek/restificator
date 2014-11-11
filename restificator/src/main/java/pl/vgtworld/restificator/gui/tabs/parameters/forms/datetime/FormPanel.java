package pl.vgtworld.restificator.gui.tabs.parameters.forms.datetime;

import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterGroup;
import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class FormPanel extends JPanel {

	private static final int TEXT_FIELD_SIZE = 20;

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private JTextField name;

	private JTextField date;

	private JTextField offset;

	private JTextField pattern;

	private JComboBox<ParameterGroup> group;

	private Date dateConverted;

	private Long offsetConverted;

	FormPanel() {
		init();
	}

	String getParameterName() {
		return name.getText();
	}

	void setParameterName(String parameterName) {
		name.setText(parameterName);
	}

	Date getParameterDate() {
		return dateConverted;
	}

	void setParameterDate(Date parameterDate) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		date.setText("" + dateFormatter.format(parameterDate));
		dateConverted = parameterDate;
	}

	long getParameterOffset() {
		return offsetConverted;
	}

	void setParameterOffset(long parameterOffset) {
		offset.setText("" + parameterOffset);
		offsetConverted = parameterOffset;
	}

	String getParameterPattern() {
		return pattern.getText();
	}

	void setParameterPattern(String parameterPattern) {
		pattern.setText(parameterPattern);
	}

	ParameterGroup getParameterGroup() {
		return group.getItemAt(group.getSelectedIndex());
	}

	void setParameterGroup(ParameterGroup parameterGroup) {
		group.setSelectedItem(parameterGroup);
	}

	boolean validateForm() {
		if (!convertDate()) {
			return false;
		}
		if (!convertOffset()) {
			return false;
		}
		return true;
	}

	private boolean convertDate() {
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
			dateConverted = dateFormatter.parse(date.getText());
			return true;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Date field is not a valid date (unknown format).", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	private boolean convertOffset() {
		try {
			offsetConverted = Long.valueOf(offset.getText());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Offset field is not a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	private void init() {
		name = new JTextField(TEXT_FIELD_SIZE);
		date = new JTextField(TEXT_FIELD_SIZE);
		offset = new JTextField(TEXT_FIELD_SIZE);
		pattern = new JTextField(TEXT_FIELD_SIZE);
		group = new JComboBox<>(ParameterGroup.values());
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();
		JLabel nameLabel = new JLabel("Name:");
		JLabel dateLabel = new JLabel("Date:");
		JLabel offsetLabel = new JLabel("Offset:");
		JLabel patternLabel = new JLabel("Pattern:");
		JLabel groupLabel = new JLabel("Group:");

		setLayout(new GridBagLayout());
		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(nameLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(name, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(dateLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(date, gbc);
		gbc.setGrid(0, 4).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(offsetLabel, gbc);
		gbc.setGrid(0, 5).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(offset, gbc);
		gbc.setGrid(0, 6).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(patternLabel, gbc);
		gbc.setGrid(0, 7).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(pattern, gbc);
		gbc.setGrid(0, 8).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(groupLabel, gbc);
		gbc.setGrid(0, 9).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.HORIZONTAL);
		add(group, gbc);
	}

}

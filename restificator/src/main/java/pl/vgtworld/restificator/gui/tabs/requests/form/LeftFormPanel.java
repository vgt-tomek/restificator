package pl.vgtworld.restificator.gui.tabs.requests.form;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.requests.RequestType;
import pl.vgtworld.restificator.gui.tabs.requests.form.headers.HeadersPanel;
import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.util.List;

class LeftFormPanel extends JPanel {

	private JTextField name;

	private JComboBox<RequestType> type;

	private JTextField path;

	private HeadersPanel headers;

	LeftFormPanel() {
		name = new JTextField();
		type = new JComboBox<>(RequestType.values());
		path = new JTextField();
		headers = new HeadersPanel();
		init();
	}

	String getRequestName() {
		return name.getText();
	}

	RequestType getRequestType() {
		return type.getItemAt(type.getSelectedIndex());
	}

	String getRequestPath() {
		return path.getText();
	}

	List<Header> getRequestHeaders() {
		return headers.readData();
	}

	private void init() {
		JLabel nameLabel = new JLabel("Name:");
		JLabel typeLabel = new JLabel("Type:");
		JLabel pathLabel = new JLabel("Path:");
		JLabel headersLabel = new JLabel("Headers:");
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();

		setLayout(new GridBagLayout());

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(nameLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(name, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(typeLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(type, gbc);
		gbc.setGrid(0, 4).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(pathLabel, gbc);
		gbc.setGrid(0, 5).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(path, gbc);
		gbc.setGrid(0, 6).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(headersLabel, gbc);
		gbc.setGrid(0, 7).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(headers, gbc);
	}

}

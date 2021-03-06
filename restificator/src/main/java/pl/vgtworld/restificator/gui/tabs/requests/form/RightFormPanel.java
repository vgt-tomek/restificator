package pl.vgtworld.restificator.gui.tabs.requests.form;

import pl.vgtworld.restificator.gui.tabs.requests.RequestDataModel;
import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;

class RightFormPanel extends JPanel {

	private JTextArea body;

	RightFormPanel() {
		init();
	}

	String getRequestBody() {
		return body.getText();
	}

	void fillWithData(RequestDataModel data) {
		body.setText(data.getBody());
	}

	private void init() {
		body = new JTextArea();
		JLabel bodyLabel = new JLabel("Body:");
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();

		setLayout(new GridBagLayout());

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.BOTH);
		add(bodyLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(new JScrollPane(body), gbc);
	}

}

package pl.vgtworld.restificator.gui.tabs.settings;

import pl.vgtworld.restificator.data.settings.Settings;
import pl.vgtworld.utils.awt.Anchor;
import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

@Singleton
class ConnectionSettings extends JPanel {

	private JTextField host = new JTextField();

	private JTextField port = new JTextField();

	@PostConstruct
	private void buildGui() {
		JLabel hostLabel = new JLabel("Host:");
		JLabel portLabel = new JLabel("Port:");
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();

		setBorder(BorderFactory.createTitledBorder("Connection"));
		setLayout(new GridBagLayout());

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(0, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.BOTH);
		add(hostLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.HORIZONTAL);
		add(host, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(0, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.BOTH);
		add(portLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.HORIZONTAL);
		add(port, gbc);
	}

	public void cleanData() {
		host.setText(null);
		port.setText(null);
	}

	public void fillWithData(Settings data) {
		host.setText(data.getHost());
		port.setText(data.getPort());
	}
}

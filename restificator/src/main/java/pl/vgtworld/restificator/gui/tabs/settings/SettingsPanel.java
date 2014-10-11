package pl.vgtworld.restificator.gui.tabs.settings;

import pl.vgtworld.utils.awt.Fill;
import pl.vgtworld.utils.awt.GridBagConstraintsImproved;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

@Singleton
public class SettingsPanel extends JPanel {

	@Inject
	private ConnectionSettings connection;

	@Inject
	private PlaceholdersSettings placeholders;

	@PostConstruct
	private void buildGui() {
		setLayout(new GridBagLayout());
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.HORIZONTAL);
		add(connection, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 0).setInsets(5).setFill(Fill.HORIZONTAL);
		add(placeholders, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setFill(Fill.BOTH);
		add(new JPanel(), gbc);
	}
}

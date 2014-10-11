package pl.vgtworld.restificator.gui.tabs.settings;

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
class PlaceholdersSettings extends JPanel {

	private JTextField prefix = new JTextField();

	private JTextField suffix = new JTextField();

	@PostConstruct
	private void buildGui() {
		JLabel prefixLabel = new JLabel("Prefix:");
		JLabel suffixLabel = new JLabel("Suffix:");
		GridBagConstraintsImproved gbc = new GridBagConstraintsImproved();

		setBorder(BorderFactory.createTitledBorder("Placeholders"));
		setLayout(new GridBagLayout());

		gbc.setGrid(0, 0).setGridSize(1, 1).setWeight(0, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.BOTH);
		add(prefixLabel, gbc);
		gbc.setGrid(0, 1).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.HORIZONTAL);
		add(prefix, gbc);
		gbc.setGrid(0, 2).setGridSize(1, 1).setWeight(0, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.BOTH);
		add(suffixLabel, gbc);
		gbc.setGrid(0, 3).setGridSize(1, 1).setWeight(100, 100).setInsets(5).setAnchor(Anchor.CENTER).setFill(Fill.HORIZONTAL);
		add(suffix, gbc);
	}
}

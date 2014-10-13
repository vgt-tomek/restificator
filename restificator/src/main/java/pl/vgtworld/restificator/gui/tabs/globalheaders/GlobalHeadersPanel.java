package pl.vgtworld.restificator.gui.tabs.globalheaders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

@Singleton
public class GlobalHeadersPanel extends JPanel {

	@Inject
	private TableModel model;

	@PostConstruct
	private void init() {
		setLayout(new BorderLayout());
		add(new JScrollPane(new JTable(model)), BorderLayout.CENTER);
	}
}

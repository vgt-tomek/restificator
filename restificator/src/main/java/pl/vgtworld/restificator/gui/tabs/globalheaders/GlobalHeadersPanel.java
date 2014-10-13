package pl.vgtworld.restificator.gui.tabs.globalheaders;

import pl.vgtworld.restificator.data.headers.Header;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.List;

@Singleton
public class GlobalHeadersPanel extends JPanel {

	@Inject
	private TableModel model;

	public void fillWithData(List<Header> globalHeaders) {
		model.clearData();
		for (Header header : globalHeaders) {
			model.addRow(header.getName(), header.getValue());
		}
	}

	@PostConstruct
	private void init() {
		setLayout(new BorderLayout());
		add(new JScrollPane(new JTable(model)), BorderLayout.CENTER);
	}

}

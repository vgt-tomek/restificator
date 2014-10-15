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

	@Inject ButtonBar buttonBar;

	private JTable table;

	public void cleanData() {
		model.clearData();
		buttonBar.setEnabledDeleteButton(false);
	}

	public void fillWithData(List<Header> globalHeaders) {
		model.clearData();
		for (Header header : globalHeaders) {
			model.addRow(header.getName(), header.getValue());
		}
	}

	int[] getSelectedRows() {
		return table.getSelectedRows();
	}

	@PostConstruct
	private void init() {
		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		table = new JTable(model);
		SelectionListener selectionListener = new SelectionListener(this, buttonBar);
		table.getSelectionModel().addListSelectionListener(selectionListener);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}

package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class HeadersPanel extends JPanel {

	private TableModel tableModel;

	private ButtonBar buttonBar;

	private JTable table;

	public  HeadersPanel() {
		init();
	}

	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		NewHeaderAction newHeaderAction = new NewHeaderAction();
		EditHeaderAction editHeaderAction = new EditHeaderAction();
		DeleteHeadersAction deleteHeadersAction = new DeleteHeadersAction();
		buttonBar = new ButtonBar(newHeaderAction, editHeaderAction, deleteHeadersAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

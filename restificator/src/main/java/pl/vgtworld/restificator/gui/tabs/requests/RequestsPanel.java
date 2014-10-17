package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.data.requests.Request;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.Map;

@Singleton
public class RequestsPanel extends JPanel {

	private TableModel tableModel;

	private JTable table;

	private ButtonBar buttonBar;

	public void cleanData() {
		//TODO Implement.
	}

	public void fillWithData(Map<String, Request> requests) {
		//TODO Implement.
	}

	public Map<String, Request> readData() {
		//TODO Implement.
		return null;
	}

	@PostConstruct
	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		NewRequestAction newRequestAction = new NewRequestAction();
		EditRequestAction editRequestAction = new EditRequestAction();
		DeleteRequestsAction deleteRequestsAction = new DeleteRequestsAction();
		buttonBar = new ButtonBar(newRequestAction, editRequestAction, deleteRequestsAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}

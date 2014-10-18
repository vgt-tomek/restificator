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
		tableModel.clearData();
		buttonBar.setEnabledEditButton(false);
		buttonBar.setEnabledDeleteButton(false);
	}

	public void fillWithData(Map<String, Request> requests) {
		tableModel.clearData();
		for (Map.Entry<String, Request> entry : requests.entrySet()) {
			String name = entry.getKey();
			Request request = entry.getValue();

			RequestDataModel tableEntry = new RequestDataModel();
			tableEntry.setName(name);
			tableEntry.setType(request.getType());
			tableEntry.setPath(request.getPath());
			tableEntry.setBody(request.getBody());
			tableEntry.setHeaders(request.getHeaders());
			tableModel.addRow(tableEntry);
		}
	}

	public Map<String, Request> readData() {
		return tableModel.readData();
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

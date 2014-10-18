package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.data.requests.Request;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.Map;

@Singleton
public class RequestsPanel extends JPanel {

	@Inject
	private TableModel tableModel;

	private JTable table;

	private ButtonBar buttonBar;

	@Inject
	private NewRequestAction newRequestAction;

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

	int[] getSelectedRows() {
		return table.getSelectedRows();
	}

	@PostConstruct
	private void init() {
		table = new JTable(tableModel);
		EditRequestAction editRequestAction = new EditRequestAction();
		DeleteRequestsAction deleteRequestsAction = new DeleteRequestsAction();
		buttonBar = new ButtonBar(newRequestAction, editRequestAction, deleteRequestsAction);
		SelectionListener selectionListener = new SelectionListener(this, buttonBar);
		table.getSelectionModel().addListSelectionListener(selectionListener);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}

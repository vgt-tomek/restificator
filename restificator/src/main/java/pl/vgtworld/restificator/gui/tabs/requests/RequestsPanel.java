package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.data.requests.Request;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Map;

@Singleton
public class RequestsPanel extends JPanel {

	private ButtonBar buttonBar;

	@PostConstruct
	private void init() {
		NewRequestAction newRequestAction = new NewRequestAction();
		EditRequestAction editRequestAction = new EditRequestAction();
		DeleteRequestsAction deleteRequestsAction = new DeleteRequestsAction();
		buttonBar = new ButtonBar(newRequestAction, editRequestAction, deleteRequestsAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
	}

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
}

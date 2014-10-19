package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class HeadersPanel extends JPanel {

	private ButtonBar buttonBar;

	public  HeadersPanel() {
		init();
	}

	private void init() {
		NewHeaderAction newHeaderAction = new NewHeaderAction();
		EditHeaderAction editHeaderAction = new EditHeaderAction();
		DeleteHeadersAction deleteHeadersAction = new DeleteHeadersAction();
		buttonBar = new ButtonBar(newHeaderAction, editHeaderAction, deleteHeadersAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
	}
}

package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import pl.vgtworld.restificator.data.headers.Header;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.util.List;

public class HeadersPanel extends JPanel {

	private TableModel tableModel;

	private ButtonBar buttonBar;

	private JTable table;

	public  HeadersPanel() {
		init();
	}

	public List<Header> readData() {
		return tableModel.readData();
	}

	int[] getSelectedRows() {
		return table.getSelectedRows();
	}

	public void fillWithData(List<Header> headers) {
		tableModel.clearData();
		for (Header header : headers) {
			tableModel.addRow(header);
		}
	}

	Header getRow(int index) {
		return tableModel.getRow(index);
	}

	void deleteRow(int index) {
		tableModel.deleteRow(index);
		table.getSelectionModel().clearSelection();
	}

	void updateRow(int index, Header row) {
		tableModel.updateRow(index, row);
	}

	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
		NewHeaderAction newHeaderAction = new NewHeaderAction(window, tableModel);
		EditHeaderAction editHeaderAction = new EditHeaderAction(window, this);
		DeleteHeadersAction deleteHeadersAction = new DeleteHeadersAction(this);
		buttonBar = new ButtonBar(newHeaderAction, editHeaderAction, deleteHeadersAction);
		SelectionListener selectionListener = new SelectionListener(this, buttonBar);
		table.getSelectionModel().addListSelectionListener(selectionListener);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}

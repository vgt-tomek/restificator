package pl.vgtworld.restificator.gui.tabs.requests.form.headers;

import pl.vgtworld.restificator.data.headers.Header;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class TableModel extends AbstractTableModel {

	private String[] columnNames = {"Name", "Value"};

	private List<Header> rows = new ArrayList<>();

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex > 1 || rowIndex > rows.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		Header row = rows.get(rowIndex);
		if (columnIndex == 0) {
			return row.getName();
		}
		if (columnIndex == 1) {
			return row.getValue();
		}
		return null;
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(1, rowCount);
	}

	void addRow(Header header) {
		rows.add(header);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index, index);
	}

	Header getRow(int index) {
		return rows.get(index);
	}

	void updateRow(int index, Header row) {
		rows.remove(index);
		rows.add(index, row);
		fireTableRowsUpdated(index + 1, index + 1);
	}

	List<Header> readData() {
		return rows;
	}

}

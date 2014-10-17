package pl.vgtworld.restificator.gui.tabs.requests;

import pl.vgtworld.restificator.data.requests.Request;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TableModel extends AbstractTableModel {

	private String[] columnNames = {"Name", "Type", "Header count"};

	private List<TableRowDataModel> rows = new ArrayList<>();

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
		if (columnIndex >= columnNames.length || rowIndex >= rows.size()) {
			throw new IndexOutOfBoundsException();
		}
		TableRowDataModel row = rows.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return row.getName();
			case 1:
				return row.getType();
			case 2:
				return row.getHeaders().size();
		}
		throw new IllegalStateException();
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(0, rowCount - 1);
	}

	void addRow(TableRowDataModel row) {
		rows.add(row);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount - 1, newRowCount - 1);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index, index);
	}

	TableRowDataModel getRow(int index) {
		return rows.get(index);
	}

	void updateRow(int index, TableRowDataModel row) {
		rows.remove(index);
		rows.add(index, row);
		fireTableRowsUpdated(index, index);
	}

	Map<String, Request> readData() {
		Map<String, Request> data = new HashMap<>();
		for (TableRowDataModel row : rows) {
			Request request = new Request();
			request.setType(row.getType());
			request.setPath(row.getPath());
			request.setHeaders(row.getHeaders());
			request.setBody(row.getBody());
			data.put(row.getName(), request);
		}
		return data;
	}

}

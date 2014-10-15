package pl.vgtworld.restificator.gui.tabs.globalheaders;

import pl.vgtworld.restificator.data.headers.Header;

import javax.inject.Singleton;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

@Singleton
class TableModel extends AbstractTableModel {

	private class DataRow {

		private String name;

		private String value;

	}

	private String[] columnNames = {"Name", "Value"};

	private List<DataRow> rows = new ArrayList<>();

	@Override
	public int getRowCount() {

		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
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
		DataRow row = rows.get(rowIndex);
		if (columnIndex == 0) {
			return row.name;
		}
		if (columnIndex == 1) {
			return row.value;
		}
		return null;
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(1, rowCount);
	}

	void addRow(String name, String value) {
		DataRow newRow = new DataRow();
		newRow.name = name;
		newRow.value = value;
		rows.add(newRow);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index, index);
	}

	Header getRow(int index) {
		DataRow row = rows.get(index);
		Header header = new Header();
		header.setName(row.name);
		header.setValue(row.value);
		return header;
	}

	void updateRow(int index, Header header) {
		DataRow dataRow = rows.get(index);
		dataRow.name = header.getName();
		dataRow.value = header.getValue();
		fireTableRowsUpdated(index, index);
	}

}

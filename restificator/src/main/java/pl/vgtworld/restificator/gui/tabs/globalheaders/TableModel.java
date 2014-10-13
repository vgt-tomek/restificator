package pl.vgtworld.restificator.gui.tabs.globalheaders;

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

	public void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(1, rowCount);
	}

	public void addRow(String name, String value) {
		DataRow newRow = new DataRow();
		newRow.name = name;
		newRow.value = value;
		rows.add(newRow);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}
}

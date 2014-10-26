package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.data.parameters.Parameter;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class TableModel extends AbstractTableModel {

	private String[] columnNames = {"Name", "Type"};

	private List<Parameter> rows = new ArrayList<>();

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
		Parameter row = rows.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return row.getName();
			case 1:
				return row.getClass().getName();

		}
		throw new IllegalArgumentException();
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(1, rowCount);
	}

	void addRow(Parameter row) {
		rows.add(row);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index + 1, index + 1);
	}

	Parameter getRow(int index) {
		return rows.get(index);
	}

	void updateRow(int index, Parameter row) {
		rows.remove(index);
		rows.add(index, row);
		fireTableRowsUpdated(index, index);
	}

	List<Parameter> readRows() {
		return rows;
	}
}

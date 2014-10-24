package pl.vgtworld.restificator.gui.tabs.tasks;

import pl.vgtworld.restificator.data.executionqueue.Task;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class TableModel extends AbstractTableModel {

	private String[] columnNames = {"name", "type"};

	private List<Task> rows = new ArrayList<>();

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
		Task row = rows.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return row.getName();
			case 1:
				return row.getType();
		}
		throw new IllegalStateException();
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(1, rowCount);
	}

	void addRow(Task row) {
		rows.add(row);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index + 1, index + 1);
	}

	Task getRow(int index) {
		return rows.get(index);
	}

	void updateRow(int index, Task row) {
		rows.remove(index);
		rows.add(index, row);
		fireTableRowsUpdated(index, index);
	}

	List<Task> readData() {
		return rows;
	}

}

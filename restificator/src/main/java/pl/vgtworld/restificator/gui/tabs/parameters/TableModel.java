package pl.vgtworld.restificator.gui.tabs.parameters;

import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class TableModel extends AbstractTableModel {

	private String[] columnNames = {"Name", "Type", "Group"};

	private List<ParameterDataModel> rows = new ArrayList<>();

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
		ParameterDataModel row = rows.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return row.getParameter().getName();
			case 1:
				String fullName = row.getParameter().getClass().getName();
				return fullName.substring(fullName.lastIndexOf('.') + 1);
			case 2:
				return row.getGroup().toString().toLowerCase();
		}
		throw new IllegalArgumentException();
	}

	void clearData() {
		int rowCount = rows.size();
		rows.clear();
		fireTableRowsDeleted(0, rowCount);
	}

	void addRow(ParameterDataModel row) {
		rows.add(row);
		int newRowCount = rows.size();
		fireTableRowsInserted(newRowCount, newRowCount);
	}

	void deleteRow(int index) {
		rows.remove(index);
		fireTableRowsDeleted(index + 1, index + 1);
	}

	ParameterDataModel getRow(int index) {
		return rows.get(index);
	}

	void updateRow(int index, ParameterDataModel row) {
		rows.remove(index);
		rows.add(index, row);
		fireTableRowsUpdated(index, index);
	}

	List<ParameterDataModel> readRows() {
		return rows;
	}
}

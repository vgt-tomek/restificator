package pl.vgtworld.restificator.gui.tabs.tasks;

import pl.vgtworld.restificator.data.executionqueue.Task;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.util.List;

@Singleton
public class TasksPanel extends JPanel {

	private TableModel tableModel;

	private JTable table;

	private ButtonBar buttonBar;

	public void cleanData() {
		tableModel.clearData();
		buttonBar.setEnabledEditButton(false);
		buttonBar.setEnabledDeleteButton(false);
	}

	public void fillWithData(List<Task> tasks) {
		tableModel.clearData();
		for (Task task : tasks) {
			tableModel.addRow(task);
		}
	}

	public List<Task> readData() {
		return tableModel.readData();
	}

	public void addRow(Task row) {
		tableModel.addRow(row);
	}

	int[] getSelectedRows() {
		return table.getSelectedRows();
	}

	Task getRow(int index) {
		return tableModel.getRow(index);
	}

	void updateRow(int index, Task row) {
		tableModel.updateRow(index, row);
	}

	@PostConstruct
	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		JFrame mainWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
		NewTaskAction newTaskAction = new NewTaskAction(mainWindow, this);
		EditTaskAction editTaskAction = new EditTaskAction(mainWindow, this);
		DeleteTasksAction deleteTasksAction = new DeleteTasksAction();
		buttonBar = new ButtonBar(newTaskAction, editTaskAction, deleteTasksAction);
		SelectionListener selectionListener = new SelectionListener(this, buttonBar);
		table.getSelectionModel().addListSelectionListener(selectionListener);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}

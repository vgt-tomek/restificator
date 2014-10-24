package pl.vgtworld.restificator.gui.tabs.tasks;

import pl.vgtworld.restificator.data.executionqueue.Task;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.ArrayList;
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
		//TODO Implementation
	}

	public List<Task> readData() {
		//TODO Implementation.
		return new ArrayList<>();
	}

	@PostConstruct
	private void init() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		NewTaskAction newTaskAction = new NewTaskAction();
		EditTaskAction editTaskAction = new EditTaskAction();
		DeleteTasksAction deleteTasksAction = new DeleteTasksAction();
		buttonBar = new ButtonBar(newTaskAction, editTaskAction, deleteTasksAction);

		setLayout(new BorderLayout());
		add(buttonBar, BorderLayout.PAGE_START);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

package pl.vgtworld.restificator.gui.tabs.tasks;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

class DeleteTasksAction extends AbstractAction {

	private TasksPanel tasksPanel;

	DeleteTasksAction(TasksPanel tasksPanel) {
		putValue(NAME, "Delete");
		this.tasksPanel = tasksPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = tasksPanel.getSelectedRows();
		for (int i = selectedRows.length - 1; i >= 0; --i) {
			tasksPanel.deleteRow(selectedRows[i]);
		}
	}

}

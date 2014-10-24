package pl.vgtworld.restificator.gui.tabs.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.executionqueue.Task;
import pl.vgtworld.restificator.gui.tabs.tasks.form.TaskFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class EditTaskAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditTaskAction.class);

	private JFrame mainWindow;

	private TasksPanel tasksPanel;

	EditTaskAction(JFrame mainWindow, TasksPanel tasksPanel) {
		putValue(NAME, "Edit");
		this.mainWindow = mainWindow;
		this.tasksPanel = tasksPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedRows = tasksPanel.getSelectedRows();
		if (selectedRows.length != 1) {
			LOGGER.warn("Only one row should be selected. Currently selected rows: {}", selectedRows.length);
			return;
		}
		int index = selectedRows[0];
		Task row = tasksPanel.getRow(index);
		TaskFormDialog dialog = new TaskFormDialog(mainWindow, row);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			tasksPanel.updateRow(index, dialog.getFilledData());
		}
		dialog.dispose();
	}

}

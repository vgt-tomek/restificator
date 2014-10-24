package pl.vgtworld.restificator.gui.tabs.tasks;

import pl.vgtworld.restificator.gui.tabs.tasks.form.TaskFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewTaskAction extends AbstractAction {

	private JFrame mainWindow;

	private TasksPanel tasksPanel;

	NewTaskAction(JFrame mainWindow, TasksPanel tasksPanel) {
		putValue(NAME, "New");
		this.mainWindow = mainWindow;
		this.tasksPanel = tasksPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TaskFormDialog dialog = new TaskFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			tasksPanel.addRow(dialog.getFilledData());
		}
		dialog.dispose();
	}

}

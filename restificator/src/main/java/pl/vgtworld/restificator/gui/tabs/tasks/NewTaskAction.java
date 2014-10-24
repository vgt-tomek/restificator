package pl.vgtworld.restificator.gui.tabs.tasks;

import pl.vgtworld.restificator.gui.tabs.tasks.form.TaskFormDialog;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

class NewTaskAction extends AbstractAction {

	private JFrame mainWindow;

	NewTaskAction(JFrame mainWindow) {
		putValue(NAME, "New");
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TaskFormDialog dialog = new TaskFormDialog(mainWindow);
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setVisible(true);
		if (dialog.isSaved()) {
			//TODO Add task to tasks panel.
		}
		dialog.dispose();
	}

}

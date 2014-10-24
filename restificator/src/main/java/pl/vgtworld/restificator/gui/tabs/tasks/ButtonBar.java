package pl.vgtworld.restificator.gui.tabs.tasks;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

class ButtonBar extends JPanel {

	private Action newTaskAction;

	private Action editTaskAction;

	private Action deleteTasksAction;

	private JButton newTaskButton;

	private JButton editTaskButton;

	private JButton deleteTasksButton;

	ButtonBar(Action newTaskAction, Action editTaskAction, Action deleteTasksAction) {
		this.newTaskAction = newTaskAction;
		this.editTaskAction = editTaskAction;
		this.deleteTasksAction = deleteTasksAction;
		init();
	}

	void setEnabledEditButton(boolean state) {
		editTaskButton.setEnabled(state);
	}

	void setEnabledDeleteButton(boolean state) {
		deleteTasksButton.setEnabled(state);
	}

	private void init() {
		newTaskButton = new JButton(newTaskAction);
		editTaskButton = new JButton(editTaskAction);
		deleteTasksButton = new JButton(deleteTasksAction);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		editTaskButton.setEnabled(false);
		deleteTasksButton.setEnabled(false);

		add(newTaskButton);
		add(editTaskButton);
		add(deleteTasksButton);
	}

}

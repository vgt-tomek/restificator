package pl.vgtworld.restificator.gui.tabs.tasks;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SelectionListener implements ListSelectionListener {

	private TasksPanel tasksPanel;

	private ButtonBar buttonBar;

	SelectionListener(TasksPanel tasksPanel, ButtonBar buttonBar) {
		this.tasksPanel = tasksPanel;
		this.buttonBar = buttonBar;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = tasksPanel.getSelectedRows();
		buttonBar.setEnabledEditButton(selectedRows.length == 1);
		buttonBar.setEnabledDeleteButton(selectedRows.length > 0);
	}
}

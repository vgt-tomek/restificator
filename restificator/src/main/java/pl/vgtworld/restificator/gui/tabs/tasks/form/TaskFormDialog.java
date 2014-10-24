package pl.vgtworld.restificator.gui.tabs.tasks.form;

import pl.vgtworld.restificator.data.executionqueue.Task;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class TaskFormDialog extends JDialog {

	private FormPanel form;

	private boolean saved;

	public TaskFormDialog(JFrame owner) {
		super(owner, true);
		init();
	}

	public boolean isSaved() {
		return saved;
	}

	public Task getFilledData() {
		Task task = new Task();
		task.setName(form.getTaskName());
		task.setType(form.getTaskType());
		return task;
	}

	private void init() {
		JButton saveButton = new JButton("Save");
		JButton cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		form = new FormPanel();

		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		setLayout(new BorderLayout());
		add(form, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);
		pack();

		saveButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = true;
				setVisible(false);
			}
		});
		cancelButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = false;
				setVisible(false);
			}
		});
	}
}

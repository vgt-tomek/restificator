package pl.vgtworld.restificator.gui.tabs.parameters.forms.counter;

import pl.vgtworld.restificator.data.parameters.Counter;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class CounterParameterFormDialog extends JDialog {

	private FormPanel form;

	private boolean saved;

	public CounterParameterFormDialog(JFrame owner) {
		super(owner, true);
		init();
	}

	public CounterParameterFormDialog(JFrame owner, ParameterDataModel data) {
		this(owner);
		fillWithData(data);
	}

	public boolean isSaved() {
		return saved;
	}

	public ParameterDataModel getFilledData() {
		Counter parameter = new Counter();
		parameter.setName(form.getParameterName());
		parameter.setValue(form.getParameterValue());
		return new ParameterDataModel(parameter, form.getParameterGroup());
	}

	public void fillWithData(ParameterDataModel data) {
		Counter parameter = (Counter) data.getParameter();
		form.setParameterName(parameter.getName());
		form.setParameterValue(parameter.getValue());
		form.setParameterGroup(data.getGroup());
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
				boolean validationResult = form.validateForm();
				if (validationResult) {
					saved = true;
					setVisible(false);
				} else {
					saved = false;
				}
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

package pl.vgtworld.restificator.gui.tabs.parameters.forms.datetime;

import pl.vgtworld.restificator.data.parameters.Datetime;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class DatetimeParameterFormDialog extends JDialog {

	private FormPanel form;

	private boolean saved;

	public DatetimeParameterFormDialog(JFrame owner) {
		super(owner, true);
		init();
	}

	public DatetimeParameterFormDialog(JFrame owner, ParameterDataModel data) {
		this(owner);
		fillWithData(data);
	}

	public boolean isSaved() {
		return saved;
	}

	public ParameterDataModel getFilledData() {
		Datetime parameter = new Datetime();
		parameter.setName(form.getParameterName());
		parameter.setDate(form.getParameterDate());
		parameter.setOffset(form.getParameterOffset());
		parameter.setPattern(form.getParameterPattern());
		return new ParameterDataModel(parameter, form.getParameterGroup());
	}

	public void fillWithData(ParameterDataModel data) {
		Datetime parameter = (Datetime) data.getParameter();
		form.setParameterName(parameter.getName());
		form.setParameterDate(parameter.getDate());
		form.setParameterOffset(parameter.getOffset());
		form.setParameterPattern(parameter.getPattern());
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

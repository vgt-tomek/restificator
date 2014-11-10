package pl.vgtworld.restificator.gui.tabs.parameters.forms.text;

import pl.vgtworld.restificator.data.parameters.Text;
import pl.vgtworld.restificator.gui.tabs.parameters.datamodel.ParameterDataModel;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class TextParameterFormDialog extends JDialog {

	private FormPanel form;

	private boolean saved;

	public TextParameterFormDialog(JFrame owner) {
		super(owner, true);
		init();
	}

	public TextParameterFormDialog(JFrame owner, ParameterDataModel data) {
		this(owner);
		fillWithData(data);
	}

	public boolean isSaved() {
		return saved;
	}

	public ParameterDataModel getFilledData() {
		Text parameter = new Text(form.getParameterName(), form.getParameterValue());
		return new ParameterDataModel(parameter, form.getParameterGroup());
	}

	public void fillWithData(ParameterDataModel data) {
		Text parameter = (Text) data.getParameter();
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

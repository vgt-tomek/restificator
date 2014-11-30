package pl.vgtworld.restificator.gui.tabs.requests.form;

import pl.vgtworld.restificator.gui.tabs.requests.RequestDataModel;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class RequestsFormDialog extends JDialog {

	private LeftFormPanel leftPanel;

	private RightFormPanel rightPanel;

	private boolean saved;

	public RequestsFormDialog(JFrame owner) {
		super(owner, true);
		leftPanel = new LeftFormPanel();
		rightPanel = new RightFormPanel();
		init();
	}

	public RequestsFormDialog(JFrame owner, RequestDataModel data) {
		this(owner);
		fillWithData(data);
	}

	public boolean isSaved() {
		return saved;
	}

	public RequestDataModel getFilledData() {
		RequestDataModel data = new RequestDataModel();
		data.setName(leftPanel.getRequestName());
		data.setType(leftPanel.getRequestType());
		data.setPath(leftPanel.getRequestPath());
		data.setHeaders(leftPanel.getRequestHeaders());
		data.setBody(rightPanel.getRequestBody());
		return data;
	}

	private void fillWithData(RequestDataModel data) {
		leftPanel.fillWithData(data);
		rightPanel.fillWithData(data);
	}

	private void init() {
		JButton saveButton = new JButton("Save");
		JButton cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		JPanel formPanel = new JPanel();

		setLayout(new BorderLayout());

		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		formPanel.setLayout(new GridLayout(1, 2));
		formPanel.add(leftPanel);
		formPanel.add(rightPanel);

		add(formPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);

		cancelButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = false;
				setVisible(false);
			}
		});
		saveButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saved = true;
				setVisible(false);
			}
		});

		setSize(800, 600);
	}

}

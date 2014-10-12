package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;
import pl.vgtworld.restificator.utils.RestificatorFileFilter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;

@Singleton
public class SaveFileAction extends AbstractAction {

	private JFileChooser saveDialog;

	@Inject
	private TabbedPane pane;

	@PostConstruct
	private void init() {
		putValue(NAME, "Save");
		saveDialog = new JFileChooser();
		saveDialog.setFileFilter(new RestificatorFileFilter());
		saveDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
		saveDialog.setDialogType(JFileChooser.SAVE_DIALOG);
		saveDialog.setMultiSelectionEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RestificatorExecutionData data = pane.readData();
		//TODO Save data to xml file.
	}
}

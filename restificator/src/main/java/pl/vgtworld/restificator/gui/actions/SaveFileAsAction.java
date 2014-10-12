package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.MainWindow;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;
import pl.vgtworld.restificator.io.SaveException;
import pl.vgtworld.restificator.io.ScriptSerializer;
import pl.vgtworld.restificator.utils.RestificatorFileFilter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveFileAsAction extends AbstractAction {

	private JFileChooser saveDialog;

	@Inject
	private TabbedPane pane;

	@Inject
	private Provider<MainWindow> mainWindowProvider;

	@PostConstruct
	private void init() {
		putValue(NAME, "Save As");
		saveDialog = new JFileChooser();
		saveDialog.setFileFilter(new RestificatorFileFilter());
		saveDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
		saveDialog.setDialogType(JFileChooser.SAVE_DIALOG);
		saveDialog.setMultiSelectionEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int saveDialogStatus = saveDialog.showSaveDialog(pane);
		if (saveDialogStatus == JFileChooser.APPROVE_OPTION) {
			try {
				File selectedFile = saveDialog.getSelectedFile();
				RestificatorExecutionData data = pane.readData();
				ScriptSerializer serializer = new ScriptSerializer();
				serializer.save(data, selectedFile);
				mainWindowProvider.get().setEditedFile(selectedFile.getAbsolutePath());
			} catch (SaveException e) {
				JOptionPane.showMessageDialog(pane, e.getMessage(), "Saving error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

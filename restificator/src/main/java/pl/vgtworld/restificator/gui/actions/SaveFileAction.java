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
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

@Singleton
public class SaveFileAction extends AbstractAction {

	private JFileChooser saveDialog;

	@Inject
	private TabbedPane pane;

	@Inject
	private Provider<MainWindow> mainWindowProvider;

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
	public void actionPerformed(ActionEvent event) {
		String editedFilepath = mainWindowProvider.get().getEditedFile();
		if (editedFilepath == null) {
			//TODO Redirect action to SaveFileAsAction.
			JOptionPane.showMessageDialog(pane, "Unsupported operation", "Saving error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		RestificatorExecutionData data = pane.readData();
		ScriptSerializer serializer = new ScriptSerializer();
		try {
			serializer.save(data, editedFilepath);
		} catch (SaveException e) {
			JOptionPane.showMessageDialog(pane, e.getMessage(), "Saving error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

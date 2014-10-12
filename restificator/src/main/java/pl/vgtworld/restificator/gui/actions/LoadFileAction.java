package pl.vgtworld.restificator.gui.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.MainWindow;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;
import pl.vgtworld.restificator.io.LoadException;
import pl.vgtworld.restificator.io.ScriptLoader;
import pl.vgtworld.restificator.utils.RestificatorFileFilter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.io.File;

@Singleton
public class LoadFileAction extends AbstractAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadFileAction.class);

	private JFileChooser openDialog;

	@Inject
	private TabbedPane pane;

	@Inject
	private Provider<MainWindow> mainWindowProvider;

	@PostConstruct
	private void init() {
		putValue(NAME, "Load");
		openDialog = new JFileChooser();
		openDialog.setFileFilter(new RestificatorFileFilter());
		openDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
		openDialog.setDialogType(JFileChooser.OPEN_DIALOG);
		openDialog.setMultiSelectionEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		openDialog.showOpenDialog(pane);
		File selectedFile = openDialog.getSelectedFile();
		if (selectedFile == null) {
			LOGGER.debug("No file chosen to load.");
			return;
		}
		LOGGER.debug("Start loading file: {}", selectedFile.getName());
		try {
			ScriptLoader loader = new ScriptLoader();
			RestificatorExecutionData loadedData = loader.load(selectedFile);
			pane.fillWithData(loadedData);
			mainWindowProvider.get().setEditedFile(selectedFile.getAbsolutePath());
		} catch (LoadException e) {
			String message = e.getMessage();
			JOptionPane.showMessageDialog(pane, message, "Loading error", JOptionPane.ERROR_MESSAGE);
		}
	}

}

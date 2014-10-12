package pl.vgtworld.restificator.gui.actions;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.MainWindow;
import pl.vgtworld.restificator.gui.tabs.TabbedPane;
import pl.vgtworld.restificator.io.SaveException;
import pl.vgtworld.restificator.io.ScriptSerializer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

@Singleton
public class SaveFileAction extends AbstractAction {

	@Inject
	private TabbedPane pane;

	@Inject
	private Provider<MainWindow> mainWindowProvider;

	@Inject
	private SaveFileAsAction saveAsAction;

	@PostConstruct
	private void init() {
		putValue(NAME, "Save");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String editedFilepath = mainWindowProvider.get().getEditedFile();
		if (editedFilepath == null) {
			saveAsAction.actionPerformed(event);
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

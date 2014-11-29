package pl.vgtworld.restificator.utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class RestificatorFileFilter extends FileFilter {

	private static final String ACCEPTED_EXTENSION = ".xml";

	@Override
	public boolean accept(File f) {
		String path = f.getAbsolutePath();
		return f.isDirectory() || path.endsWith(ACCEPTED_EXTENSION);
	}

	@Override
	public String getDescription() {
		return "Restificator XML file";
	}
}

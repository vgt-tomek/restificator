package pl.vgtworld.restificator;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.loader.LoadException;
import pl.vgtworld.restificator.loader.ScriptLoader;

public class Restificator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Restificator.class);
	
	private static final Logger OUTPUT = LoggerFactory.getLogger("output");
	
	public static void main(String[] args) {
		LOGGER.debug("Start application");
		
		try {
			CmdParser cmdParser = new CmdParser();
			cmdParser.parse(args);
			switch (cmdParser.getAction()) {
			case CREATE:
				LOGGER.debug("Create new script");
				OUTPUT.info("Creating new script is not supported in this version.");
				break;
			case EDIT:
				LOGGER.debug("Edit existing script");
				OUTPUT.info("Editing script is not supported in this version.");
				break;
			case EXECUTE:
				LOGGER.debug("Execute script");
				RestificatorExecutionData scriptData = loadScript(cmdParser.getFilePath());
				OUTPUT.info("" + scriptData);
				//TODO
				break;
			case HELP:
				cmdParser.displayHelp();
				break;
			}
		} catch (ParseException | LoadException e) {
			OUTPUT.info(e.getMessage());
		}
	}
	
	private static RestificatorExecutionData loadScript(String path) throws LoadException {
		ScriptLoader loader = new ScriptLoader();
		return loader.load(path);
	}
}

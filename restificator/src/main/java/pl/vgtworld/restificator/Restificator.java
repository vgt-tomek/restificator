package pl.vgtworld.restificator;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.crawler.ExecutionException;
import pl.vgtworld.restificator.crawler.RestCrawler;
import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.loader.LoadException;
import pl.vgtworld.restificator.loader.ScriptLoader;

public class Restificator {
	
	public static final String OUTPUT_LOGGER_NAME = "output";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Restificator.class);
	
	private static final Logger OUTPUT = LoggerFactory.getLogger(OUTPUT_LOGGER_NAME);
	
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
				try {
					LOGGER.debug("Load script from " + cmdParser.getFilePath());
					RestificatorExecutionData scriptData = loadScript(cmdParser.getFilePath());
					RestCrawler crawler = new RestCrawler();
					LOGGER.debug("Execute script: " + scriptData);
					crawler.executeScript(scriptData);
				} catch (ExecutionException e) {
					OUTPUT.error("There was an error while executing script");
					LOGGER.debug("Exception while executing script", e);
				}
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

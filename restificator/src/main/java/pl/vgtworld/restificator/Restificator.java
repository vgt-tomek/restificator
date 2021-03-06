package pl.vgtworld.restificator;

import java.awt.*;
import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.crawler.ExecutionException;
import pl.vgtworld.restificator.crawler.RestCrawler;
import pl.vgtworld.restificator.data.RestificatorExecutionData;
import pl.vgtworld.restificator.gui.MainWindow;
import pl.vgtworld.restificator.io.LoadException;
import pl.vgtworld.restificator.io.ScriptLoader;
import pl.vgtworld.restificator.stats.ExecutionStatistics;
import pl.vgtworld.restificator.validator.XmlValidator;

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
			case EXECUTE:
				try {
					LOGGER.debug("Load script from " + cmdParser.getFilePath());
					RestificatorExecutionData scriptData = loadScript(cmdParser.getFilePath());
					XmlValidator validator = new XmlValidator();
					if (!validator.validate(scriptData)) {
						OUTPUT.error("Validation error: {}", validator.getError());
						return;
					}
					RestCrawler crawler = new RestCrawler();
					LOGGER.debug("Execute script: " + scriptData);
					ExecutionStatistics statistics = crawler.executeScript(scriptData);
					OUTPUT.info("" + statistics);
				} catch (ExecutionException e) {
					OUTPUT.error("There was an error while executing script");
					LOGGER.debug("Exception while executing script", e);
				}
				break;
			case HELP:
				cmdParser.displayHelp();
				break;
			case VERSION:
				Properties properties = new Properties();
				OUTPUT.info("Restificator version: {}", properties.getVersion());
				OUTPUT.info("Build timestamp: {}", properties.getBuildTimestamp());
				break;
			case GUI:
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						Weld weld = new Weld();
						WeldContainer container = weld.initialize();
						MainWindow window = container.instance().select(MainWindow.class).get();
						window.setVisible(true);
					}
				});
				break;
			}
		} catch (ParseException | LoadException | IOException e) {
			OUTPUT.info(e.getMessage());
		}
	}
	
	private static RestificatorExecutionData loadScript(String path) throws LoadException {
		ScriptLoader loader = new ScriptLoader();
		return loader.load(path);
	}

}

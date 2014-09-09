package pl.vgtworld.restificator;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Restificator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Restificator.class);
	
	private static final Logger OUTPUT = LoggerFactory.getLogger("output");
	
	public static void main(String[] args) {
		LOGGER.debug("Start application");
		
		try {
			CmdParser cmdParser = new CmdParser();
			if (args.length >= 1 && args[0].equals("--help")) {
				cmdParser.displayHelp();
				return;
			}
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
				//TODO
				break;
			}
		} catch (ParseException e) {
			OUTPUT.info(e.getMessage());
		}
	}
	
}

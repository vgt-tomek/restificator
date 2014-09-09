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
		} catch (ParseException e) {
			OUTPUT.info(e.getMessage());
		}
	}
	
}

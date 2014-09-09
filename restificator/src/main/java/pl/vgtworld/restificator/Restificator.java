package pl.vgtworld.restificator;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Restificator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Restificator.class);
	
	public static void main(String[] args) {
		LOGGER.debug("Start application");
		
		try {
			CmdParser cmdParser = new CmdParser();
			cmdParser.parse(args);
		} catch (ParseException e) {
			LOGGER.error("Unexpected exception while parsing command line arguments. message: {}", e.getMessage());
		}
	}
	
}

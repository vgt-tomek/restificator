package pl.vgtworld.restificator;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CmdParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmdParser.class);
	
	private Options options;
	
	private CommandLine cmd;
	
	CmdParser() {
		initializeParser();
	}
	
	void parse(String[] args) throws ParseException {
		CommandLineParser parser = new BasicParser();
		LOGGER.debug("Parsing arguments: {}", (Object)args);
		cmd = parser.parse(options, args);
	}
	
	boolean hasOption(String option) {
		return cmd.hasOption(option);
	}
	
	void displayHelp() {
		HelpFormatter help = new HelpFormatter();
		help.printHelp("java -jar restificator.jar [parameters]", options);
	}
	
	private void initializeParser() {
		Option executeOption = new Option(null, "file", true, "Path to script file");
		Option actionOption = new Option(null, "action", true, "Action to take on file [create|edit|execute]");
		options = new Options();
		options.addOption(executeOption);
		options.addOption(actionOption);
	}
	
}

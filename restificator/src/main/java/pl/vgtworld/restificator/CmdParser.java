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
	
	private static final String FILE_OPTION = "file";

	private static final String ACTION_OPTION = "action";

	private static final String HELP_OPTION = "help";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmdParser.class);

	private Options options;
	
	private CommandLine cmd;
	
	private String validationErrorMessage;
	
	CmdParser() {
		initializeParser();
	}
	
	void parse(String[] args) throws ParseException {
		CommandLineParser parser = new BasicParser();
		LOGGER.debug("Parsing arguments: {}", (Object)args);
		cmd = parser.parse(options, args);
		validate();
	}
	
	boolean hasOption(String option) {
		return cmd.hasOption(option);
	}
	
	boolean isValid() {
		return validationErrorMessage == null;
	}
	
	String getValidationErrorMessage() {
		return validationErrorMessage;
	}
	
	void displayHelp() {
		HelpFormatter help = new HelpFormatter();
		help.printHelp("java -jar restificator.jar [parameters]", options);
	}
	
	private void validate() {
		validationErrorMessage = null;
		if (!hasOption(ACTION_OPTION)) {
			validationErrorMessage = "Action parameter is missing. See --help for more info.";
			return;
		}
		if (!hasOption(FILE_OPTION)) {
			validationErrorMessage = "File parameter is missing. See --help for more info.";
			return;
		}
	}
	
	private void initializeParser() {
		Option executeOption = new Option(null, FILE_OPTION, true, "Path to script file");
		Option actionOption = new Option(null, ACTION_OPTION, true, "Action to take on file [create|edit|execute]");
		Option helpOption = new Option(null, HELP_OPTION, true, "Help screen");
		options = new Options();
		options.addOption(executeOption);
		options.addOption(actionOption);
		options.addOption(helpOption);
	}
	
}

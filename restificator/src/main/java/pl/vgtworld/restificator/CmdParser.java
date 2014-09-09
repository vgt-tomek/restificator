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
		options = new Options();
		
		Option fileOption = new Option(null, FILE_OPTION, true, "Path to script file");
		fileOption.setRequired(true);
		options.addOption(fileOption);
		
		Option actionOption = new Option(null, ACTION_OPTION, true, "Action to take on file [create|edit|execute]");
		actionOption.setRequired(true);
		options.addOption(actionOption);
		
		Option helpOption = new Option(null, HELP_OPTION, false, "Help screen");
		options.addOption(helpOption);
	}
	
}

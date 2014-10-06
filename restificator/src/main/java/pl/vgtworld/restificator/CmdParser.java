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
	
	public enum Action {
		GUI, EXECUTE, HELP, VERSION
	}
	
	private static final String FILE_OPTION = "file";
	
	private static final String HELP_OPTION = "help";
	
	private static final String VERSION_OPTION = "version";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmdParser.class);

	private Options options;

	private CommandLine cmd;
	
	private Action activeAction;
	
	CmdParser() {
		options = initializeOptions();
	}
	
	void parse(String[] args) throws ParseException {
		if (args.length == 0) {
			activeAction = Action.GUI;
			return;
		}
		CommandLineParser parser = new BasicParser();
		LOGGER.debug("Parsing arguments: {}", (Object) args);
		cmd = parser.parse(options, args);
		if (cmd.hasOption(HELP_OPTION)) {
			activeAction = Action.HELP;
			return;
		}
		if (cmd.hasOption(VERSION_OPTION)) {
			activeAction = Action.VERSION;
			return;
		}
		if (cmd.hasOption(FILE_OPTION)) {
			activeAction = Action.EXECUTE;
			return;
		}
		throw new ParseException("Invalid usage. See --help for more information.");
	}
	
	Action getAction() {
		return activeAction;
	}
	
	String getFilePath() {
		return cmd.getOptionValue(FILE_OPTION);
	}
	
	void displayHelp() {
		HelpFormatter help = new HelpFormatter();
		help.printHelp(
				"java -jar restificator.jar [parameters]",
				"",
				options,
				"If no parameters are provided, GUI version is executed."
		);
	}

	private Options initializeOptions() {
		Options options = new Options();
		
		Option fileOption = new Option(null, FILE_OPTION, true, "Path to script file, that should be executed");
		options.addOption(fileOption);
		
		Option helpOption = new Option(null, HELP_OPTION, false, "Help screen");
		options.addOption(helpOption);
		
		Option versionOption = new Option(null, VERSION_OPTION, false, "Display version");
		options.addOption(versionOption);
		
		return options;
	}
	
}

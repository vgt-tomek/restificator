package pl.vgtworld.restificator;

import java.util.ArrayList;
import java.util.List;

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
		CREATE, EDIT, EXECUTE, HELP, VERSION
	};
	
	private static final String FILE_OPTION = "file";
	
	private static final String ACTION_OPTION = "action";
	
	private static final String HELP_OPTION = "help";
	
	private static final String VERSION_OPTION = "version";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmdParser.class);

	private Options coreOptions;
	
	private Options additionalOptions;
	
	private CommandLine cmd;
	
	private List<String> actionAllowedValues;
	
	private Action activeAction;
	
	CmdParser() {
		initializeAllowedValues();
		initializeCoreOptions();
		initializeAdditionalOptions();
	}
	
	void parse(String[] args) throws ParseException {
		CommandLineParser parser = new BasicParser();
		LOGGER.debug("Parsing arguments: {}", (Object) args);
		cmd = parser.parse(additionalOptions, args);
		if (cmd.hasOption(HELP_OPTION)) {
			activeAction = Action.HELP;
			return;
		}
		if (cmd.hasOption(VERSION_OPTION)) {
			activeAction = Action.VERSION;
			return;
		}
		cmd = parser.parse(coreOptions, args);
		if (!actionAllowedValues.contains(cmd.getOptionValue(ACTION_OPTION))) {
			throw new ParseException("Unknown action. See --help for more information.");
		}
		activeAction = Action.valueOf(cmd.getOptionValue(ACTION_OPTION).toUpperCase());
	}
	
	Action getAction() {
		return activeAction;
	}
	
	boolean hasOption(String option) {
		return cmd.hasOption(option);
	}
	
	String getFilePath() {
		return cmd.getOptionValue(FILE_OPTION);
	}
	
	void displayHelp() {
		HelpFormatter help = new HelpFormatter();
		help.printHelp("java -jar restificator.jar [parameters]", coreOptions);
	}
	
	private void initializeCoreOptions() {
		coreOptions = initializeOptions(true);
	}
	
	private void initializeAdditionalOptions() {
		additionalOptions = initializeOptions(false);
	}
	
	private Options initializeOptions(boolean restrictRequired) {
		Options options = new Options();
		
		Option fileOption = new Option(null, FILE_OPTION, true, "Path to script file");
		if (restrictRequired) {
			fileOption.setRequired(true);
		}
		options.addOption(fileOption);
		
		Option actionOption = new Option(null, ACTION_OPTION, true, "Action to take on file "
				+ actionAllowedValues.toString());
		if (restrictRequired) {
			actionOption.setRequired(true);
		}
		options.addOption(actionOption);
		
		Option helpOption = new Option(null, HELP_OPTION, false, "Help screen");
		options.addOption(helpOption);
		
		Option versionOption = new Option(null, VERSION_OPTION, false, "Display version");
		options.addOption(versionOption);
		
		return options;
	}
	
	private void initializeAllowedValues() {
		actionAllowedValues = new ArrayList<>();
		for (Action action : Action.values()) {
			actionAllowedValues.add(action.toString().toLowerCase());
		}
	}
}

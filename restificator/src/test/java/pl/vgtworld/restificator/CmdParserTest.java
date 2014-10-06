package pl.vgtworld.restificator;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import pl.vgtworld.restificator.CmdParser.Action;

public class CmdParserTest {
	
	private static final String XML_FILENAME = "file.xml";
	
	private static final String ACTION_EXECUTE = "execute";
	
	private static final String VERSION_PARAMETER_NAME = "--version";
	
	private static final String HELP_PARAMETER_NAME = "--help";
	
	private static final String FILE_PARAMETER_NAME = "--file";
	
	private static final String ACTION_PARAMETER_NAME = "--action";
	
	private CmdParser cmdParser = new CmdParser();
	
	@Test(expected = ParseException.class)
	public void shouldThrowExceptionWhenFileParameterIsMissing() throws ParseException {
		cmdParser.parse(new String[] { ACTION_PARAMETER_NAME, ACTION_EXECUTE });
	}
	
	@Test(expected = ParseException.class)
	public void shouldThrowExceptionWhenActionParameterIsMissing() throws ParseException {
		cmdParser.parse(new String[] { FILE_PARAMETER_NAME, XML_FILENAME });
	}
	
	@Test
	public void shouldSetActionToHelpWhenProperParameterIsUsed() throws ParseException {
		cmdParser.parse(new String[] { HELP_PARAMETER_NAME });
		
		assertThat(cmdParser.getAction()).isEqualTo(Action.HELP);
	}
	
	@Test
	public void shouldSetActionToVersionWhenProperParameterIsUsed() throws ParseException {
		cmdParser.parse(new String[] { VERSION_PARAMETER_NAME });
		
		assertThat(cmdParser.getAction()).isEqualTo(Action.VERSION);
	}
	
	@Test
	public void shouldSetActionToExecuteWhenProperparametersAreUsed() throws ParseException {
		cmdParser.parse(new String[] { ACTION_PARAMETER_NAME, ACTION_EXECUTE, FILE_PARAMETER_NAME, XML_FILENAME });
		
		assertThat(cmdParser.getAction()).isEqualTo(Action.EXECUTE);
	}
	
}

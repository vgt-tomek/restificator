package pl.vgtworld.restificator.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import pl.vgtworld.restificator.data.RestificatorExecutionData;

public class ScriptLoaderTest {
	
	@Test
	public void shouldSuccessfullyParseExampleXml() throws LoadException {
		URL resource = getClass().getResource("/example-xml/2014-09-26.xml");
		File file = new File(resource.getFile());
		ScriptLoader loader = new ScriptLoader();
		
		RestificatorExecutionData data = loader.load(file);
		
		assertThat(data).isNotNull();
	}
	
	@Test(expected = LoadException.class)
	public void shouldThrowExceptionOnMissingFile() throws LoadException {
		File file = new File("/some/abstract/path");
		ScriptLoader loader = new ScriptLoader();
		
		loader.load(file);
	}
	
}

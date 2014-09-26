package pl.vgtworld.restificator.data.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TextTest {
	
	@Test
	public void shouldUseProvidedValue() {
		Text text = new Text("some-name", "some-value");
		
		String result = text.getParameterValue();
		
		assertThat(result).isEqualTo("some-value");
	}
	
}

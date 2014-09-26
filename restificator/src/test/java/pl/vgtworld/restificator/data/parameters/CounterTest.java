package pl.vgtworld.restificator.data.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CounterTest {

	@Test
	public void shouldIncreaseInternalCounterValueAfterEachCall() {
		Counter counter = new Counter();
		counter.setValue(21);
		
		String firstResult = counter.getParameterValue();
		String secondResult = counter.getParameterValue();
		
		assertThat(firstResult).isEqualTo("21");
		assertThat(secondResult).isEqualTo("22");
	}
}

package pl.vgtworld.restificator.crawler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Text;

public class ParametersMapperTest {
	
	@Test
	public void shouldMergeTwoParameterLists() {
		List<Parameter> first = new ArrayList<>();
		List<Parameter> second = new ArrayList<>();
		first.add(createParameter("a", "a-value"));
		first.add(createParameter("b", "b-value"));
		second.add(createParameter("c", "c-value"));
		second.add(createParameter("d", "d-value"));
		ParametersMapper mapper = new ParametersMapper();
		
		Map<String, Parameter> result = mapper.mergeParameterLists(first, second);
		
		assertThat(result).hasSize(4);
		assertThat(result).containsKey("a");
		assertThat(result).containsKey("b");
		assertThat(result).containsKey("c");
		assertThat(result).containsKey("d");
	}
	
	private Parameter createParameter(String name, String value) {
		return new Text(name, value);
	}
}

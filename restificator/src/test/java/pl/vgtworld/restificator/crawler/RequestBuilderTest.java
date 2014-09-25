package pl.vgtworld.restificator.crawler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import pl.vgtworld.restificator.data.headers.Header;
import pl.vgtworld.restificator.data.parameters.Parameter;
import pl.vgtworld.restificator.data.parameters.Text;
import pl.vgtworld.restificator.data.requests.Request;
import pl.vgtworld.restificator.data.requests.RequestType;

public class RequestBuilderTest {
	
	private static final String LOCAL_HEADER2_VALUE = "local-value2";
	
	private static final String LOCAL_HEADER2_NAME = "local-header2";
	
	private static final String LOCAL_HEADER1_VALUE = "local-value1";
	
	private static final String LOCAL_HEADER1_NAME = "local-header1";
	
	private static final String GLOBAL_HEADER2_VALUE = "global-value2";
	
	private static final String GLOBAL_HEADER2_NAME = "global-header2";
	
	private static final String GLOBAL_HEADER1_VALUE = "global-value1";
	
	private static final String GLOBAL_HEADER1_NAME = "global-header1";
	
	private static final String PARAMETER2_VALUE = "param-value2";
	
	private static final String PARAMETER1_VALUE = "param-value1";
	
	private static final String PARAMETER2_NAME = "parameter2";
	
	private static final String PARAMETER1_NAME = "parameter1";
	
	private static final String REQUEST_BODY = "example-body";
	
	private static final String REQUEST_PATH = "/example/path/to/resource";
	
	@Test
	public void shouldProperlyBuildRequestBasedOnProvidedData() {
		RequestBuilder builder = new RequestBuilder(createExampleGlobalHeaders(), createExampleParameters());
		builder.setPlaceholderBoundaries("{{", "}}");
		
		String result = builder.buildRequest(createExampleRequest());
		
		assertThat(result).startsWith(String.format("POST %s HTTP/1.0", REQUEST_PATH));
		assertThat(result).contains(GLOBAL_HEADER1_NAME + ": " + GLOBAL_HEADER1_VALUE);
		assertThat(result).contains(GLOBAL_HEADER2_NAME + ": " + GLOBAL_HEADER2_VALUE);
		assertThat(result).contains(LOCAL_HEADER1_NAME + ": " + LOCAL_HEADER1_VALUE);
		assertThat(result).contains(LOCAL_HEADER2_NAME + ": " + LOCAL_HEADER2_VALUE);
		assertThat(result).contains("Content-length: " + REQUEST_BODY.length());
		assertThat(result).contains(REQUEST_BODY);
	}
	
	@Test
	public void shouldReplaceParameterPlaceholderInRequestBody() {
		RequestBuilder builder = new RequestBuilder(createExampleGlobalHeaders(), createExampleParameters());
		builder.setPlaceholderBoundaries("{{", "}}");
		Request requestTemplate = createExampleRequest();
		requestTemplate.setBody("example {{" + PARAMETER1_NAME + "}} body");
		
		String result = builder.buildRequest(requestTemplate);
		
		assertThat(result).contains("example " + PARAMETER1_VALUE + " body");
	}
	
	@Test
	public void shouldReplaceParameterPlaceholderInPath() {
		RequestBuilder builder = new RequestBuilder(createExampleGlobalHeaders(), createExampleParameters());
		builder.setPlaceholderBoundaries("{{", "}}");
		Request requestTemplate = createExampleRequest();
		requestTemplate.setPath("/example/path/to/resource/{{" + PARAMETER2_NAME + "}}");
		
		String result = builder.buildRequest(requestTemplate);
		
		assertThat(result).contains("/example/path/to/resource/" + PARAMETER2_VALUE);
	}
	
	@Test
	public void shouldReplaceParameterPlaceholderInHeaderValue() {
		List<Header> globalHeaders = createExampleGlobalHeaders();
		globalHeaders.add(createHeader("additionalParam", "{{" + PARAMETER1_NAME + "}}"));
		RequestBuilder builder = new RequestBuilder(globalHeaders, createExampleParameters());
		builder.setPlaceholderBoundaries("{{", "}}");
		Request requestTemplate = createExampleRequest();
		
		String result = builder.buildRequest(requestTemplate);
		
		assertThat(result).contains("additionalParam: " + PARAMETER1_VALUE);
	}
	
	@Test
	public void shouldUseLocalHeaderWhenGlobalAndLocalHeaderUseTheSameName() {
		List<Header> globalHeaders = createExampleGlobalHeaders();
		List<Header> localHeaders = createExampleLocalHeaders();
		String additionalHeaderName = "additionalHeader";
		globalHeaders.add(createHeader(additionalHeaderName, "global-test"));
		localHeaders.add(createHeader(additionalHeaderName, "local-test"));
		RequestBuilder builder = new RequestBuilder(globalHeaders, createExampleParameters());
		builder.setPlaceholderBoundaries("{{", "}}");
		Request requestTemplate = createExampleRequest();
		requestTemplate.setHeaders(localHeaders);
		
		String result = builder.buildRequest(requestTemplate);
		
		assertThat(result).contains(additionalHeaderName + ": local-test");
		assertThat(result).doesNotContain(additionalHeaderName + ": global-test");
	}
	
	private Request createExampleRequest() {
		Request request = new Request();
		request.setType(RequestType.POST);
		request.setHeaders(createExampleLocalHeaders());
		request.setPath(REQUEST_PATH);
		request.setBody(REQUEST_BODY);
		return request;
	}

	private Map<String, Parameter> createExampleParameters() {
		Map<String, Parameter> map = new HashMap<>();
		map.put(PARAMETER1_NAME, createExampleParameter(PARAMETER1_NAME, PARAMETER1_VALUE));
		map.put(PARAMETER2_NAME, createExampleParameter(PARAMETER2_NAME, PARAMETER2_VALUE));
		return map;
	}

	private Parameter createExampleParameter(String name, String value) {
		return new Text(name, value);
	}

	private List<Header> createExampleGlobalHeaders() {
		List<Header> list = new ArrayList<>();
		list.add(createHeader(GLOBAL_HEADER1_NAME, GLOBAL_HEADER1_VALUE));
		list.add(createHeader(GLOBAL_HEADER2_NAME, GLOBAL_HEADER2_VALUE));
		return list;
	}

	private List<Header> createExampleLocalHeaders() {
		List<Header> list = new ArrayList<>();
		list.add(createHeader(LOCAL_HEADER1_NAME, LOCAL_HEADER1_VALUE));
		list.add(createHeader(LOCAL_HEADER2_NAME, LOCAL_HEADER2_VALUE));
		return list;
	}

	private Header createHeader(String name, String value) {
		Header header = new Header();
		header.setName(name);
		header.setValue(value);
		return header;
	}
	
}

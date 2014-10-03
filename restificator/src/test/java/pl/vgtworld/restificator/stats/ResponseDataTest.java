package pl.vgtworld.restificator.stats;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ResponseDataTest {

	private static final String RESPONSE_STATUS_CODE = "200";

	private static final String RESPONSE_STATUS = "HTTP/1.1 " + RESPONSE_STATUS_CODE + " OK";

	private static final String RESPONSE_HEADERS = "Header-One: value1\nHeader-Two: value2";

	private static final String RESPONSE_BODY = "response-body";

	private static final String EXAMPLE_RESPONSE = RESPONSE_STATUS + "\n" + RESPONSE_HEADERS + "\n\n" + RESPONSE_BODY;

	@Test
	public void shouldUseNotAvailableAsStatusCodeWhenResponseIsNull() {
		ResponseData response = new ResponseData(null);

		Assertions.assertThat(response.getStatusCode()).isEqualTo("N/A");
	}

	@Test
	public void shouldUseNotAvailableAsStatusCodeWhenResponseUseInvalidOneLineFormat() {
		ResponseData response = new ResponseData("invalid response");

		Assertions.assertThat(response.getStatusCode()).isEqualTo("N/A");
	}

	@Test
	public void shouldUseNotAvailableAsStatusCodeWhenResponseUseInvalidMultiLineFormat() {
		ResponseData response = new ResponseData("invalid response\nmultiline");

		Assertions.assertThat(response.getStatusCode()).isEqualTo("N/A");
	}

	@Test
	public void shouldSuccessfullyExtractStatusCodeFromValidResponse() {
		ResponseData response = new ResponseData(EXAMPLE_RESPONSE);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(RESPONSE_STATUS_CODE);
	}

	@Test
	public void shouldUseNotAvailableAsBodyWhenResponseIsNull() {
		ResponseData response = new ResponseData(null);

		Assertions.assertThat(response.getBody()).isEqualTo("N/A");
	}

	@Test
	public void shouldUseNotAvailableAsBodyWhenResponseUseInvalidOneLineFormat() {
		ResponseData response = new ResponseData("invalid response");

		Assertions.assertThat(response.getBody()).isEqualTo("N/A");
	}

	@Test
	public void shouldUseNotAvailableAsBodyWhenResponseUseInvalidMultiLineFormat() {
		ResponseData response = new ResponseData("invalid response\nmultiline");

		Assertions.assertThat(response.getBody()).isEqualTo("N/A");
	}

	@Test
	public void shouldSuccessfullyExtractBodyFromValidResponse() {
		ResponseData response = new ResponseData(EXAMPLE_RESPONSE);

		Assertions.assertThat(response.getBody()).isEqualTo(RESPONSE_BODY);
	}
}
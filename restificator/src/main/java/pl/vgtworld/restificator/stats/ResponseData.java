package pl.vgtworld.restificator.stats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ResponseData {

	private String rawResponse;

	private String statusCode;

	private String body;

	ResponseData(String response) {
		rawResponse = response;
		parseStatusCode();
		parseBody();
	}

	String getStatusCode() {
		return statusCode;
	}

	String getBody() {
		return body;
	}

	private void parseStatusCode() {
		if (rawResponse == null || rawResponse.isEmpty()) {
			statusCode = "N/A";
			return;
		}
		int lineBreakIndex = rawResponse.indexOf('\n');
		if (lineBreakIndex == -1) {
			statusCode = "N/A";
			return;
		}
		String firstLine = rawResponse.substring(0, lineBreakIndex);

		Pattern pattern = Pattern.compile("[0-9]{3}");
		Matcher matcher = pattern.matcher(firstLine);
		if (matcher.find()) {
			statusCode = matcher.group();
		} else {
			statusCode = "N/A";
		}
	}

	private void parseBody() {
		if (rawResponse == null || rawResponse.isEmpty()) {
			body = "N/A";
			return;
		}
		String emptyLineMarker = "\n\n";
		int emptyLineIndex = rawResponse.indexOf(emptyLineMarker);
		if (emptyLineIndex == -1) {
			body = "N/A";
			return;
		}
		body = rawResponse.substring(emptyLineIndex + emptyLineMarker.length());
	}
}

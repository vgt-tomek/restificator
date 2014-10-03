package pl.vgtworld.restificator.stats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ResponseData {

	private String rawResponse;

	private String statusCode;

	ResponseData(String response) {
		rawResponse = response;
		parseStatusCode();
	}

	public String getStatusCode() {
		return statusCode;
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

}

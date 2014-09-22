package pl.vgtworld.restificator;

import java.io.IOException;

public class Properties {
	
	private static final String PATH = "/restificator.properties";
	
	private static final String KEY_VERSION = "restificator.version";
	
	private static final String KEY_BUILD_TIMESTAMP = "restificator.build.timestamp";
	
	private java.util.Properties properties = null;
	
	public Properties() throws IOException {
		properties = new java.util.Properties();
		properties.load(getClass().getResourceAsStream(PATH));
	}
	
	public String getVersion() {
		return properties.getProperty(KEY_VERSION);
	}
	
	public String getBuildTimestamp() {
		return properties.getProperty(KEY_BUILD_TIMESTAMP);
	}
	
}

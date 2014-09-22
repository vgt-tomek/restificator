package pl.vgtworld.restificator;

import java.io.IOException;

public class Properties {
	
	private static final String PATH = "/restificator.properties";
	
	private static final String KEY_VERSION = "restificator.version";
	
	private java.util.Properties properties = null;
	
	public Properties() throws IOException {
		properties = new java.util.Properties();
		properties.load(getClass().getResourceAsStream(PATH));
	}
	
	public String getVersion() {
		return properties.getProperty(KEY_VERSION);
	}
	
}

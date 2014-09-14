package pl.vgtworld.restificator.data.settings;

public class Settings {
	
	private String host;
	
	private String port;
	
	private String placeholderPrefix;
	
	private String placeholderSuffix;
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getPlaceholderPrefix() {
		return placeholderPrefix;
	}
	
	public void setPlaceholderPrefix(String placeholderPrefix) {
		this.placeholderPrefix = placeholderPrefix;
	}
	
	public String getPlaceholderSuffix() {
		return placeholderSuffix;
	}
	
	public void setPlaceholderSuffix(String placeholderSuffix) {
		this.placeholderSuffix = placeholderSuffix;
	}
	
	@Override
	public String toString() {
		return "Settings [host=" + host + ", port=" + port + ", placeholderPrefix=" + placeholderPrefix
				+ ", placeholderSuffix=" + placeholderSuffix + "]";
	}
	
}

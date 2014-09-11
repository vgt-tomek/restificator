package pl.vgtworld.restificator.loader;

public class LoadException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LoadException(String message) {
		super(message);
	}
	
	public LoadException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

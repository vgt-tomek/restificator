package pl.vgtworld.restificator.validator;

class XmlValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	XmlValidationException(String message) {
		super(message);
	}
	
	XmlValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

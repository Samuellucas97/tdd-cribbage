package swtest101.cribbage.exception;

public class InvalidInputHandException extends InputParseException {

	private static final long serialVersionUID = 6091746319469492556L;

	public InvalidInputHandException(String errorMsg) {
		super(errorMsg);
	}

}

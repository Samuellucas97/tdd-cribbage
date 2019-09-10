package swtest101.cribbage.exception;

public class InvalidHandStringException extends InputParseException {

	private static final long serialVersionUID = 8529998931908829465L;

	public InvalidHandStringException(String errorMsg) {
		super(errorMsg);

	}
}

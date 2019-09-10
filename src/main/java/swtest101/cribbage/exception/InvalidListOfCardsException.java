package swtest101.cribbage.exception;

public class InvalidListOfCardsException extends InputParseException {

	private static final long serialVersionUID = 1L;

	public InvalidListOfCardsException(String errorMsg) {
		super(errorMsg);
	}
}

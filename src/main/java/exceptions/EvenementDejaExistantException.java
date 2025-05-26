package exceptions;

public class EvenementDejaExistantException extends Exception {
	 private static final long serialVersionUID = 1L;

	public EvenementDejaExistantException(String message) {
	        super(message);
	    }
}

package library;

public class LibraryException extends Exception {

	private static final long serialVersionUID = -7142354595644623056L;

	public LibraryException() {
		super();
	}

	public LibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibraryException(String message) {
		super(message);
	}

	public LibraryException(Throwable cause) {
		super(cause);
	}


}

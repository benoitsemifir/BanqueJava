package banque.Exceptions;

public class BanqueExceptionCompteMax extends BanqueException {

	private static final long serialVersionUID = 1L;

	public BanqueExceptionCompteMax() {
		super();
	}

	public BanqueExceptionCompteMax(String message) {
		super(message);
	}

	public BanqueExceptionCompteMax(Throwable cause) {
		super(cause);
	}

	public BanqueExceptionCompteMax(String message, Throwable cause) {
		super(message, cause);
	}

}

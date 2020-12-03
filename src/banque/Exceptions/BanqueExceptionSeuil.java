package banque.Exceptions;

public class BanqueExceptionSeuil extends BanqueException {

	private static final long serialVersionUID = 1L;

	public BanqueExceptionSeuil() {
		super();
	}

	public BanqueExceptionSeuil(String message) {
		super(message);
	}

	public BanqueExceptionSeuil(Throwable cause) {
		super(cause);
	}

	public BanqueExceptionSeuil(String message, Throwable cause) {
		super(message, cause);
	}

}

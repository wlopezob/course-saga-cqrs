package pe.edu.galaxy.training.java.sb.ms.msautorizacionsagapedidos.exceptions;

public class RetryableMessagingException extends RuntimeException {

	private static final long serialVersionUID = -6999114012758055059L;

	public RetryableMessagingException(final String message) {
        super(message);
    }
}
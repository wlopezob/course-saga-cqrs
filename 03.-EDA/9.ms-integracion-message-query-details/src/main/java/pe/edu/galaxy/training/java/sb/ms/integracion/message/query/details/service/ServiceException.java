package pe.edu.galaxy.training.java.sb.ms.integracion.message.query.details.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6576481318430081698L;

	public ServiceException() {
		
	}

	public ServiceException(String message) {
		super(message);
		
	}

	public ServiceException(Throwable cause) {
		super(cause);
		
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}

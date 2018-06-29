package gov.psm.primary.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtilException extends Exception {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	public CommonUtilException() {
		super();
	}

	public CommonUtilException(Throwable e) {
		super(e);
		String msg = this.getMessage();
		Throwable cause = this.getCause();
		LOGGER.error(msg, cause);
	}

	public CommonUtilException(String msg) {
		super(msg);
		LOGGER.error(msg);
	}

	public CommonUtilException(String msg, Throwable cause) {
		super(msg, cause);
		LOGGER.error(msg, cause);
	}

	public String getErrMsg() {
		return this.getMessage();
	}
}

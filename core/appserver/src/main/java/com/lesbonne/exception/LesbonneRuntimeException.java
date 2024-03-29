package com.lesbonne.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yucheng
 * @since 1
 * */
@SuppressWarnings("serial")
public class LesbonneRuntimeException extends RuntimeException {

	private ErrorCode errorCode;
	private final Map<String, Object> properties = new TreeMap<String, Object>();
	
	public LesbonneRuntimeException() {
		super();
	}
	
	public LesbonneRuntimeException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public LesbonneRuntimeException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public LesbonneRuntimeException(Throwable cause, ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public LesbonneRuntimeException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public static LesbonneRuntimeException wrap(Throwable exception,
			ErrorCode errorCode) {
		if (exception instanceof LesbonneRuntimeException) {
			LesbonneRuntimeException se = (LesbonneRuntimeException) exception;
			if (errorCode != null && errorCode != se.getErrorCode()) {
				return new LesbonneRuntimeException(exception.getMessage(),
						exception, errorCode);
			}
			return se;
		} else {
			return new LesbonneRuntimeException(exception.getMessage(),
					exception, errorCode);
		}
	}

	public static LesbonneRuntimeException wrap(Throwable exception) {
		return wrap(exception, null);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public LesbonneRuntimeException setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) properties.get(name);
	}

	public LesbonneRuntimeException set(String name, Object value) {
		properties.put(name, value);
		return this;
	}

	public void printStackTrace(PrintStream s) {
		synchronized (s) {
			printStackTrace(new PrintWriter(s));
		}
	}

	public void printStackTrace(PrintWriter s) {
		synchronized (s) {
			s.println(this);
			s.println("\t-------------------------------");
			if (errorCode != null) {
				s.println("\t" + errorCode + ":"
						+ errorCode.getClass().getName());
			}
			for (String key : properties.keySet()) {
				s.println("\t" + key + "=[" + properties.get(key) + "]");
			}
			s.println("\t-------------------------------");
			StackTraceElement[] trace = getStackTrace();
			for (int i = 0; i < trace.length; i++)
				s.println("\tat " + trace[i]);

			Throwable ourCause = getCause();
			if (ourCause != null) {
				ourCause.printStackTrace(s);
			}
			s.flush();
		}
	}
}

package main.java.commons;

import java.io.IOException;

@SuppressWarnings("serial")
public class CommonException extends Exception {

	public CommonException() {
		super();
	}

	public CommonException(String string) {
		super(string);
	}

	public CommonException(String string, Exception exception) {
		super(string, exception);
	}
}

package com.capgemini.jstk.boardGame.exceptions;

public class ExistingUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5145210328435257508L;

	public ExistingUsernameException() {
		super("Username already exist!");
	}

	public ExistingUsernameException(String message) {
		super("Username already exist!" + message);
	}

}

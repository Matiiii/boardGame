package com.capgemini.jstk.boardGame.exceptions;

public class UserNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5145210328575857508L;

	public UserNotExistException() {
		super("User not exist!");
	}

	public UserNotExistException(String message) {
		super("User not exist! " + message);
	}
}

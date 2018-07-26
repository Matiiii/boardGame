package com.capgemini.jstk.boardGame.exceptions;

public class NotExistChallengeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063201558070221295L;

	public NotExistChallengeException() {
		super("There are challenge like expected!");
	}

	public NotExistChallengeException(String message) {
		super("There are challenge like expected! " + message);
	}
}

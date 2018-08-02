package com.capgemini.jstk.boardGame.exceptions;

public class NotExistChallengeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063201558070221295L;

	public NotExistChallengeException() {
		super("Don't have this challenge!");
	}

	public NotExistChallengeException(String message) {
		super("Don't have this challenge! " + message);
	}
}

package com.capgemini.jstk.boardGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capgemini.jstk.boardGame.exceptions.ErrorMessage;
import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;

@ControllerAdvice
public class GlobalControllerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage playerExceptionHandler(Exception ex) {
		LOGGER.error("Error in player service: ", ex);
		return new ErrorMessage(ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(UserNotExistException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage UserNotFoundException(Exception ex) {
		LOGGER.error("Error in player service: ", ex);
		return new ErrorMessage(ex.getMessage());
	}

}

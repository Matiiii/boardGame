package com.capgemini.jstk.boardGame.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jstk.boardGame.exceptions.ExistingUsernameException;
import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.repository.dto.GameTo;
import com.capgemini.jstk.boardGame.repository.dto.UserSearchTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;
import com.capgemini.jstk.boardGame.services.UserService;

@RestController

public class UserControler {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControler.class);

	private UserService userService;

	@Autowired
	public UserControler(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users/{nickName}", method = RequestMethod.GET)
	public ResponseEntity<UserTo> getPlayerByNickname(@PathVariable(value = "nickName") String nickName)
			throws UserNotExistException {
		UserTo UserTo = userService.getUserByName(nickName);
		return new ResponseEntity<>(UserTo, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/users/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserTo> addNewUser(@RequestBody UserTo user) throws ExistingUsernameException {
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/gamesearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<UserTo>> getUsersByGame(@RequestBody GameTo game) throws UserNotExistException {
		Set<UserTo> usersTo = userService.findUsersByGame(game);
		return new ResponseEntity<>(usersTo, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<UserTo>> getUsersByCriteria(@RequestBody UserSearchTo userSearchTo) {
		Set<UserTo> usersTo = userService.findUsersByCriteria(userSearchTo);
		return new ResponseEntity<>(usersTo, HttpStatus.FOUND);
	}

}

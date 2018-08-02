package com.capgemini.jstk.boardGame.services;

import java.util.Set;

import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.repository.dto.AvailableTimeTo;
import com.capgemini.jstk.boardGame.repository.dto.GameTo;
import com.capgemini.jstk.boardGame.repository.dto.UserSearchTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;

public interface UserService {
	/**
	 * 
	 * @param string
	 * @return
	 * @throws UserNotExistException
	 */
	Set<UserTo> findUsersByBasicInformation(String string) throws UserNotExistException;

	Set<UserTo> findUsersByGame(GameTo game);

	Set<UserTo> findUsersByAvailableTime(AvailableTimeTo time);

	/**
	 * 
	 * @param user
	 */
	void addUser(UserTo user);

	UserTo getUserByName(String nickname) throws UserNotExistException;

	Set<UserTo> findUsersByCriteria(UserSearchTo userSearchTo);

}

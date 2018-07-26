package com.capgemini.jstk.boardGame.services;

import java.util.Set;

import com.capgemini.jstk.boardGame.dto.AvalibleTimeDto;
import com.capgemini.jstk.boardGame.dto.GameDto;
import com.capgemini.jstk.boardGame.dto.UserDto;

public interface UserServiceInterface {

	Set<UserDto> findUsersByBasicInformation(String string);

	Set<UserDto> findUsersByGame(GameDto game);

	Set<UserDto> findUserSByAvalibleTime(AvalibleTimeDto time);

	/**
	 * 
	 * @param user
	 */
	void addUser(UserDto user);

}

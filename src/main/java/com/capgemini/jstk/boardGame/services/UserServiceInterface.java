package com.capgemini.jstk.boardGame.services;

import java.util.Set;

import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;

public interface UserServiceInterface {

	Set<UserDto> findUsersByBasicInformation(String string);

	Set<UserDto> findUsersByGame(GameEntiti game);

	Set<UserDto> findUserSByAvalibleTime(AvalibleTimeEntiti time);

	void addUser(UserDto user);

}

package com.capgemini.jstk.boardGame.repository.dao;

import java.util.Set;

import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.repository.entity.AvailableTimeEntity;
import com.capgemini.jstk.boardGame.repository.entity.GameEntity;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

public interface UserDao {
	Set<UserEntity> getUsersByGame(GameEntity game);

	UserEntity getUserByUserName(String string) throws UserNotExistException;

	Set<UserEntity> getUsersByAvailable(AvailableTimeEntity time);

	void addUser(UserEntity user);

	void addGameToUser(UserEntity user, GameEntity game) throws UserNotExistException;

	UserEntity getUserByUserEmail(String email) throws UserNotExistException;

	Set<UserEntity> getUsersByCity(String city);

}

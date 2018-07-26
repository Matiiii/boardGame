package com.capgemini.jstk.boardGame.services.impl;

import java.util.Set;

import com.capgemini.jstk.boardGame.dao.UserDaoInterface;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.mapper.GameMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.services.UserServiceInterface;

public class UserServiceImpl implements UserServiceInterface {

	private UserDaoInterface userDao;

	private UserMapper userMapper;

	private GameMapper gameMapper;

	private AvalibleTimeMapper avalibleTimeMapper;

	@Override
	public Set<UserDto> findUsersByBasicInformation(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UserDto> findUsersByGame(GameEntiti game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UserDto> findUserSByAvalibleTime(AvalibleTimeEntiti time) {

		return userDao.getUserByAvalible(a);
	}

	@Override
	public void addUser(UserDto user) {

		userDao.addUser(userMapper.map(user));

	}

}

package com.capgemini.jstk.boardGame.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardGame.dao.UserDaoInterface;
import com.capgemini.jstk.boardGame.dto.AvalibleTimeDto;
import com.capgemini.jstk.boardGame.dto.GameDto;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.mapper.AvalibleTimeMapper;
import com.capgemini.jstk.boardGame.mapper.GameMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.model.UserEntiti;
import com.capgemini.jstk.boardGame.services.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {

	private UserDaoInterface userDao;

	private UserMapper userMapper;

	private GameMapper gameMapper;

	private AvalibleTimeMapper avalibleTimeMapper;

	@Autowired
	public UserServiceImpl(UserDaoInterface userDao, UserMapper userMapper, GameMapper gameMapper,
			AvalibleTimeMapper avalibleTimeMapper) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.gameMapper = gameMapper;
		this.avalibleTimeMapper = avalibleTimeMapper;
	}

	@Override
	public Set<UserDto> findUsersByBasicInformation(String string) {
		Set<UserEntiti> lista = new HashSet<>();
		lista = userDao.getUserByUserName(string);

		lista.addAll(userDao.getUserByUserEmail(string));

		return userMapper.map2To(userDao.getUserByUserName(string));
	}

	@Override
	public Set<UserDto> findUsersByGame(GameDto game) {

		return userMapper.map2To(userDao.getUsersByGame(gameMapper.map(game)));
	}

	@Override
	public Set<UserDto> findUserSByAvalibleTime(AvalibleTimeDto time) {

		return userMapper.map2To(userDao.getUserByAvalible(avalibleTimeMapper.map(time)));
	}

	@Override
	public void addUser(UserDto user) {

		userDao.addUser(userMapper.map(user));

	}

}

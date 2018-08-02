package com.capgemini.jstk.boardGame.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.mapper.AvalibleTimeMapper;
import com.capgemini.jstk.boardGame.mapper.GameMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.repository.dao.UserDao;
import com.capgemini.jstk.boardGame.repository.dto.AvailableTimeTo;
import com.capgemini.jstk.boardGame.repository.dto.GameTo;
import com.capgemini.jstk.boardGame.repository.dto.UserSearchTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;
import com.capgemini.jstk.boardGame.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private UserMapper userMapper;

	private GameMapper gameMapper;

	private AvalibleTimeMapper avalibleTimeMapper;

	@Autowired
	public UserServiceImpl(UserDao userDao, UserMapper userMapper, GameMapper gameMapper,
			AvalibleTimeMapper avalibleTimeMapper) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.gameMapper = gameMapper;
		this.avalibleTimeMapper = avalibleTimeMapper;
	}

	@Override
	public Set<UserTo> findUsersByBasicInformation(String string) throws UserNotExistException {
		Set<UserEntity> lista = new HashSet<>();
		try {
			lista.add(userDao.getUserByUserName(string));

			lista.add(userDao.getUserByUserEmail(string));
		} catch (Exception e) {

		}

		return userMapper.map2To(lista);
	}

	@Override
	public Set<UserTo> findUsersByGame(GameTo game) {

		return userMapper.map2To(userDao.getUsersByGame(gameMapper.map(game)));
	}

	@Override
	public Set<UserTo> findUsersByAvailableTime(AvailableTimeTo time) {

		return userMapper.map2To(userDao.getUsersByAvailable(avalibleTimeMapper.map(time)));
	}

	@Override
	public void addUser(UserTo user) {

		userDao.addUser(userMapper.map(user));

	}

	@Override
	public UserTo getUserByName(String nickname) throws UserNotExistException {

		UserEntity userEntity = userDao.getUserByUserName(nickname);

		return userMapper.map(userEntity);

	}

	@Override
	public Set<UserTo> findUsersByCriteria(UserSearchTo userSearchTo) {

		Set<UserEntity> usersByCity = userDao.getUsersByCity(userSearchTo.getCity());
		Set<UserEntity> usersByGame = userDao.getUsersByGame(gameMapper.map(userSearchTo.getGames()));
		Set<UserEntity> usersByAvailable = userDao
				.getUsersByAvailable(avalibleTimeMapper.map(userSearchTo.getAvailables()));

		Set<UserEntity> filteredListEntity = usersByCity;
		filteredListEntity.retainAll(usersByGame);
		filteredListEntity.retainAll(usersByAvailable);

		Set<UserTo> fiteredListTo = userMapper.map2To(filteredListEntity);

		return fiteredListTo;
	}

}

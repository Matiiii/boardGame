package com.capgemini.jstk.boardGame.repository.dao.impl;

import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.repository.dao.UserDao;
import com.capgemini.jstk.boardGame.repository.entity.AvailableTimeEntity;
import com.capgemini.jstk.boardGame.repository.entity.GameEntity;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	private MockDataInitializer mockDataInitializer;

	@Autowired
	public UserDaoImpl(MockDataInitializer mockDataInitializer) {
		this.mockDataInitializer = mockDataInitializer;
	}

	@PostConstruct
	public void init() {
		addUser(mockDataInitializer.user1);
		addUser(mockDataInitializer.user2);
		addUser(mockDataInitializer.user3);
		addUser(mockDataInitializer.user4);
		addUser(mockDataInitializer.user5);
		userList.forEach(x -> System.out.println(x.getUserName()));
	}

	private Set<UserEntity> userList = new HashSet<>();

	@Override
	public Set<UserEntity> getUsersByGame(GameEntity game) {

		return userList.stream()
				.filter(user -> user.getOwnGames().stream()
						.anyMatch(gameList -> gameList.getGameName().equals(game.getGameName())))
				.collect(Collectors.toSet());
	}

	@Override
	public UserEntity getUserByUserName(String string) throws UserNotExistException {
		UserEntity userEntity;
		try {
			userEntity = userList.stream().filter(user -> user.getUserName().equals(string)).findFirst().get();
		} catch (Exception e) {
			throw new UserNotExistException();
		}
		return userEntity;
	}

	private boolean isTimeInPeriod(Instant timeToCheckStart, Instant timeToCheckStop, Instant timeStart,
			Instant timeStop) {

		boolean isTTCStartIn = timeToCheckStart.isAfter(timeStart) && timeToCheckStart.isBefore(timeStop);
		boolean isTTCStopIn = timeToCheckStop.isAfter(timeStart) && timeToCheckStop.isBefore(timeStop);
		boolean isTStartIn = timeStart.isAfter(timeToCheckStart) && timeStart.isBefore(timeToCheckStop);
		boolean isTStopIn = timeStop.isAfter(timeToCheckStart) && timeStop.isBefore(timeToCheckStop);

		return isTTCStartIn || isTTCStopIn || isTStartIn || isTStopIn;

	};

	@Override
	public Set<UserEntity> getUsersByAvailable(AvailableTimeEntity time) {

		return userList.stream()
				.filter(user -> user.getAvailable().stream()
						.anyMatch(availableTime -> isTimeInPeriod(availableTime.getTimeStart(),
								availableTime.getTimeStop(), time.getTimeStart(), time.getTimeStop())))
				.collect(Collectors.toSet());

	}

	@Override
	public void addUser(UserEntity user) {
		userList.add(user);

	}

	@Override
	public void addGameToUser(UserEntity user, GameEntity game) throws UserNotExistException {
		getUserByUserName(user.getUserName()).getOwnGames().add(game);

	}

	@Override
	public UserEntity getUserByUserEmail(String email) throws UserNotExistException {

		Optional<UserEntity> userEntity = userList.stream().filter(user -> user.getEmail().equals(email)).findFirst();

		try {
			userEntity.get();
		} catch (Exception e) {
			throw new UserNotExistException("with email: " + email);
		}

		return userEntity.get();
	}

	@Override
	public Set<UserEntity> getUsersByCity(String city) {

		return userList.stream().filter(user -> user.getCity().equals(city)).collect(Collectors.toSet());
	}

}

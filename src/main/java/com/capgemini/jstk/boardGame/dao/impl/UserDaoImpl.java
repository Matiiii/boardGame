package com.capgemini.jstk.boardGame.dao.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.dao.UserDaoInterface;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Repository
public class UserDaoImpl implements UserDaoInterface {

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

	private Set<UserEntiti> userList = new HashSet<>();

	@Override
	public Set<UserEntiti> getUsersByGame(GameEntiti game) {

		return userList.stream()
				.filter(x -> x.getOwnGames().stream().anyMatch(y -> y.getGameName().equals(game.getGameName())))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<UserEntiti> getUserByUserName(String string) {

		return userList.stream().filter(x -> x.getUserName().equals(string)).collect(Collectors.toSet());
	}

	@Override
	public Set<UserEntiti> getUserByAvalible(AvalibleTimeEntiti time) {

		return userList.stream()
				.filter(x -> x.getAvalible().stream()
						.anyMatch(y -> ((y.getTimeStart().isAfter(time.getTimeStart())
								&& y.getTimeStart().isBefore(time.getTimeStop()))
								|| (y.getTimeStop().isAfter(time.getTimeStart())
										&& y.getTimeStop().isBefore(time.getTimeStop())))
				|| ((time.getTimeStop().isAfter(y.getTimeStart()) && time.getTimeStop().isBefore(y.getTimeStop()))
						|| (time.getTimeStart().isAfter(y.getTimeStart())
								&& time.getTimeStart().isBefore(y.getTimeStop())))))
				.collect(Collectors.toSet());

	}

	@Override
	public void addUser(UserEntiti user) {
		userList.add(user);

	}

	@Override
	public void addGameToUser(UserEntiti user, GameEntiti game) {
		getUserByUserName(user.getUserName()).forEach(x -> x.getOwnGames().add(game));

	}

	@Override
	public Set<UserEntiti> getUserByUserEmail(String email) {

		return userList.stream().filter(x -> x.getEmail().equals(email)).collect(Collectors.toSet());
	}

}

package com.capgemini.jstk.boardGame.repository.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserEntity {

	private String userName;
	private String password;
	private String email;
	private String city;

	private Set<GameEntity> ownGames = new HashSet<>();
	private Set<AvailableTimeEntity> available = new HashSet<>();
	private Map<GameEntity, Integer> gamePoints = new HashMap<>();

	public void addGame(GameEntity game) {
		ownGames.add(game);
	}

	public void addAvalibleTime(AvailableTimeEntity time) {
		available.add(time);
	}

	public UserEntity() {
		super();

	}

	public UserEntity(String userName, String password, String email, String city, Set<GameEntity> ownGames,
			Set<AvailableTimeEntity> avalible) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ownGames = ownGames;
		this.available = avalible;
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<GameEntity> getOwnGames() {
		return ownGames;
	}

	public void setOwnGames(Set<GameEntity> ownGames) {
		this.ownGames = ownGames;
	}

	public Set<AvailableTimeEntity> getAvailable() {
		return available;
	}

	public void setAvailable(Set<AvailableTimeEntity> available) {
		this.available = available;
	}

	public Map<GameEntity, Integer> getGamePoints() {
		return gamePoints;
	}

	public void setGamePoints(Map<GameEntity, Integer> gamePoints) {
		this.gamePoints = gamePoints;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

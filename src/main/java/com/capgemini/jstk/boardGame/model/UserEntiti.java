package com.capgemini.jstk.boardGame.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserEntiti {

	private String userName;
	private String password;
	private String email;

	private Set<GameEntiti> ownGames = new HashSet<>();
	private Set<AvalibleTimeEntiti> avalible = new HashSet<>();
	private Map<GameEntiti, Integer> gamePoints = new HashMap<>();

	public void addGame(GameEntiti game) {
		ownGames.add(game);
	}

	public void addAvalibleTime(AvalibleTimeEntiti time) {
		avalible.add(time);
	}

	public UserEntiti() {
		super();

	}

	public UserEntiti(String userName, String password, String email, Set<GameEntiti> ownGames,
			Set<AvalibleTimeEntiti> avalible) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ownGames = ownGames;
		this.avalible = avalible;
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

	public Set<GameEntiti> getOwnGames() {
		return ownGames;
	}

	public void setOwnGames(Set<GameEntiti> ownGames) {
		this.ownGames = ownGames;
	}

	public Set<AvalibleTimeEntiti> getAvalible() {
		return avalible;
	}

	public void setAvalible(Set<AvalibleTimeEntiti> avalible) {
		this.avalible = avalible;
	}

	public Map<GameEntiti, Integer> getGamePoints() {
		return gamePoints;
	}

	public void setGamePoints(Map<GameEntiti, Integer> gamePoints) {
		this.gamePoints = gamePoints;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

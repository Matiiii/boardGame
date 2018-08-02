package com.capgemini.jstk.boardGame.repository.dto;

public class UserSearchTo {

	private String city;
	private GameTo game;
	private AvailableTimeTo availables;

	public UserSearchTo(String city, GameTo games, AvailableTimeTo availables) {
		this.city = city;
		this.game = games;
		this.availables = availables;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GameTo getGames() {
		return game;
	}

	public void setGames(GameTo game) {
		this.game = game;
	}

	public AvailableTimeTo getAvailables() {
		return availables;
	}

	public void setAvailables(AvailableTimeTo availables) {
		this.availables = availables;
	}

}

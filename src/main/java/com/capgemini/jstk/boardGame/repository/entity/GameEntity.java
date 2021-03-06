package com.capgemini.jstk.boardGame.repository.entity;

public class GameEntity {

	private String gameName;

	int minialPlayers;
	int maximalPlayers;

	public GameEntity() {
	}

	public GameEntity(String gameName, int minialPlayers, int maximalPlayers) {
		this.gameName = gameName;
		this.minialPlayers = minialPlayers;
		this.maximalPlayers = maximalPlayers;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMinialPlayers() {
		return minialPlayers;
	}

	public void setMinialPlayers(int minialPlayers) {
		this.minialPlayers = minialPlayers;
	}

	public int getMaximalPlayers() {
		return maximalPlayers;
	}

	public void setMaximalPlayers(int maximalPlayers) {
		this.maximalPlayers = maximalPlayers;
	}

}

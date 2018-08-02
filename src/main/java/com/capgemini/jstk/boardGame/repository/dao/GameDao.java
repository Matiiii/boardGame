package com.capgemini.jstk.boardGame.repository.dao;

import com.capgemini.jstk.boardGame.repository.entity.GameEntity;

public interface GameDao {

	GameEntity getGameByGameName(String name);

	void addGame(GameEntity game);

}

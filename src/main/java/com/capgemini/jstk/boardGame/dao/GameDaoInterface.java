package com.capgemini.jstk.boardGame.dao;

import com.capgemini.jstk.boardGame.model.GameEntiti;

public interface GameDaoInterface {

	GameEntiti getGameByGameName(String name);

	void addGame(GameEntiti game);

}

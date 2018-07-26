package com.capgemini.jstk.boardGame.dao.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.dao.GameDaoInterface;
import com.capgemini.jstk.boardGame.model.GameEntiti;

@Repository
public class GameDaoImpl implements GameDaoInterface {

	MockDataInitializer mockdata;

	@Autowired
	public GameDaoImpl(MockDataInitializer mockdata) {
		this.mockdata = mockdata;
	}

	@PostConstruct
	public void init() {
		addGame(mockdata.game1);
		addGame(mockdata.game2);
		addGame(mockdata.game3);
		addGame(mockdata.game4);

	}

	Set<GameEntiti> gameList = new HashSet<>();

	@Override
	public GameEntiti getGameByGameName(String name) {

		return null;
	}

	@Override
	public void addGame(GameEntiti game) {
		gameList.add(game);

	}

}

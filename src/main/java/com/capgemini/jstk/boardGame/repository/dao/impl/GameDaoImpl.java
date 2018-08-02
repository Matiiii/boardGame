package com.capgemini.jstk.boardGame.repository.dao.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.repository.dao.GameDao;
import com.capgemini.jstk.boardGame.repository.entity.GameEntity;

@Repository
public class GameDaoImpl implements GameDao {

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

	Set<GameEntity> gameList = new HashSet<>();

	@Override
	public GameEntity getGameByGameName(String name) {

		return null;
	}

	@Override
	public void addGame(GameEntity game) {
		gameList.add(game);

	}

}

package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.GameTo;
import com.capgemini.jstk.boardGame.repository.entity.GameEntity;

@Component
public class GameMapper {

	public GameTo map(GameEntity gameEntiti) {
		if (gameEntiti != null) {
			return new GameTo(gameEntiti.getGameName(), gameEntiti.getMinialPlayers(), gameEntiti.getMaximalPlayers());
		}
		return null;
	}

	public GameEntity map(GameTo gameDto) {
		if (gameDto != null) {
			return new GameEntity(gameDto.getGameName(), gameDto.getMinialPlayers(), gameDto.getMaximalPlayers());
		}
		return null;
	}

	public List<GameTo> map2To(List<GameEntity> gameEntiti) {
		return gameEntiti.stream().map(this::map).collect(Collectors.toList());
	}

	public List<GameEntity> map2Entity(List<GameTo> gameDto) {
		return gameDto.stream().map(this::map).collect(Collectors.toList());
	}

}

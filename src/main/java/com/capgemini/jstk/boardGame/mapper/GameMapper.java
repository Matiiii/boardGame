package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.GameDto;
import com.capgemini.jstk.boardGame.model.GameEntiti;

@Component
public class GameMapper {

	public GameDto map(GameEntiti gameEntiti) {
		if (gameEntiti != null) {
			return new GameDto(gameEntiti.getGameName(), gameEntiti.getMinialPlayers(), gameEntiti.getMaximalPlayers());
		}
		return null;
	}

	public GameEntiti map(GameDto gameDto) {
		if (gameDto != null) {
			return new GameEntiti(gameDto.getGameName(), gameDto.getMinialPlayers(), gameDto.getMaximalPlayers());
		}
		return null;
	}

	public List<GameDto> map2To(List<GameEntiti> gameEntiti) {
		return gameEntiti.stream().map(new GameMapper()::map).collect(Collectors.toList());
	}

	public List<GameEntiti> map2Entity(List<GameDto> gameDto) {
		return gameDto.stream().map(new GameMapper()::map).collect(Collectors.toList());
	}

}

package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Component
public class UserMapper {

	public UserDto map(UserEntiti userEntiti) {
		if (userEntiti != null) {
			return new UserDto(userEntiti.getUserName(), userEntiti.getPassword(), userEntiti.getEmail(),
					userEntiti.getOwnGames(), userEntiti.getAvalible());
		}
		return null;
	}

	public UserEntiti map(UserDto userDto) {
		if (userDto != null) {
			return new UserEntiti(userDto.getUserName(), userDto.getPassword(), userDto.getEmail(),
					userDto.getOwnGames(), userDto.getAvalible());
		}
		return null;
	}

	public List<UserDto> map2To(List<UserEntiti> userEntiti) {
		return userEntiti.stream().map(new UserMapper()::map).collect(Collectors.toList());
	}

	public List<UserEntiti> map2Entity(List<UserDto> userDto) {
		return userDto.stream().map(new UserMapper()::map).collect(Collectors.toList());
	}

}

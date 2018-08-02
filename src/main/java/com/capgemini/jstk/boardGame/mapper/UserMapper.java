package com.capgemini.jstk.boardGame.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.UserTo;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

@Component
public class UserMapper {

	public UserTo map(UserEntity userEntiti) {
		if (userEntiti != null) {
			return new UserTo(userEntiti.getUserName(), userEntiti.getPassword(), userEntiti.getEmail(),
					userEntiti.getCity(), userEntiti.getOwnGames(), userEntiti.getAvailable());
		}
		return null;
	}

	public UserEntity map(UserTo userDto) {
		if (userDto != null) {
			return new UserEntity(userDto.getUserName(), userDto.getPassword(), userDto.getEmail(), userDto.getCity(),
					userDto.getOwnGames(), userDto.getAvailable());
		}
		return null;
	}

	public Set<UserTo> map2To(Set<UserEntity> userEntiti) {
		return userEntiti.stream().map(this::map).collect(Collectors.toSet());
	}

	public Set<UserEntity> map2Entity(Set<UserTo> userDto) {
		return userDto.stream().map(this::map).collect(Collectors.toSet());
	}

}

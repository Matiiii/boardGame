package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.AcceptationTo;
import com.capgemini.jstk.boardGame.repository.entity.AcceptationEntity;

@Component
public class AcceptationMapper {

	public AcceptationTo map(AcceptationEntity acceptationEntiti) {
		if (acceptationEntiti != null) {
			return new AcceptationTo(acceptationEntiti.isActeptation(), acceptationEntiti.getComment());
		}
		return null;
	}

	public AcceptationEntity map(AcceptationTo acceptationDto) {
		if (acceptationDto != null) {
			return new AcceptationEntity(acceptationDto.isActeptation(), acceptationDto.getComment());
		}
		return null;
	}

	public List<AcceptationTo> map2To(List<AcceptationEntity> acceptationEntiti) {
		return acceptationEntiti.stream().map(this::map).collect(Collectors.toList());
	}

	public List<AcceptationEntity> map2Entity(List<AcceptationTo> acceptationDto) {
		return acceptationDto.stream().map(this::map).collect(Collectors.toList());
	}

}

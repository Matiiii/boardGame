package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.model.AcceptationEntiti;

@Component
public class AcceptationMapper {

	public AcceptationDto map(AcceptationEntiti acceptationEntiti) {
		if (acceptationEntiti != null) {
			return new AcceptationDto(acceptationEntiti.isActeptation(), acceptationEntiti.getComment());
		}
		return null;
	}

	public AcceptationEntiti map(AcceptationDto acceptationDto) {
		if (acceptationDto != null) {
			return new AcceptationEntiti(acceptationDto.isActeptation(), acceptationDto.getComment());
		}
		return null;
	}

	public List<AcceptationDto> map2To(List<AcceptationEntiti> acceptationEntiti) {
		return acceptationEntiti.stream().map(new AcceptationMapper()::map).collect(Collectors.toList());
	}

	public List<AcceptationEntiti> map2Entity(List<AcceptationDto> acceptationDto) {
		return acceptationDto.stream().map(new AcceptationMapper()::map).collect(Collectors.toList());
	}

}

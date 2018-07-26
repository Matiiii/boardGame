package com.capgemini.jstk.boardGame.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.AvalibleTimeDto;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;

@Component
public class AvalibleTimeMapper {

	public AvalibleTimeDto map(AvalibleTimeEntiti avalibleTimeEntiti) {
		if (avalibleTimeEntiti != null) {
			return new AvalibleTimeDto(avalibleTimeEntiti.getTimeStart(), avalibleTimeEntiti.getTimeStop());
		}
		return null;
	}

	public AvalibleTimeEntiti map(AvalibleTimeDto avalibleTimeDto) {
		if (avalibleTimeDto != null) {
			return new AvalibleTimeEntiti(avalibleTimeDto.getTimeStart(), avalibleTimeDto.getTimeStop());
		}
		return null;
	}

	public Set<AvalibleTimeDto> map2To(Set<AvalibleTimeEntiti> avalibleTimeEntiti) {
		return avalibleTimeEntiti.stream().map(new AvalibleTimeMapper()::map).collect(Collectors.toSet());
	}

	public Set<AvalibleTimeEntiti> map2Entity(Set<AvalibleTimeDto> avalibleTimeDto) {
		return avalibleTimeDto.stream().map(new AvalibleTimeMapper()::map).collect(Collectors.toSet());
	}

}

package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
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

	public List<AvalibleTimeDto> map2To(List<AvalibleTimeEntiti> avalibleTimeEntiti) {
		return avalibleTimeEntiti.stream().map(new AvalibleTimeMapper()::map).collect(Collectors.toList());
	}

	public List<AvalibleTimeEntiti> map2Entity(List<AvalibleTimeDto> avalibleTimeDto) {
		return avalibleTimeDto.stream().map(new AvalibleTimeMapper()::map).collect(Collectors.toList());
	}

}

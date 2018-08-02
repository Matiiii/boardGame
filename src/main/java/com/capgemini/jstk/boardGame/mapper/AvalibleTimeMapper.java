package com.capgemini.jstk.boardGame.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.AvailableTimeTo;
import com.capgemini.jstk.boardGame.repository.entity.AvailableTimeEntity;

@Component
public class AvalibleTimeMapper {

	public AvailableTimeTo map(AvailableTimeEntity avalibleTimeEntiti) {
		if (avalibleTimeEntiti != null) {
			return new AvailableTimeTo(avalibleTimeEntiti.getTimeStart(), avalibleTimeEntiti.getTimeStop());
		}
		return null;
	}

	public AvailableTimeEntity map(AvailableTimeTo avalibleTimeDto) {
		if (avalibleTimeDto != null) {
			return new AvailableTimeEntity(avalibleTimeDto.getTimeStart(), avalibleTimeDto.getTimeStop());
		}
		return null;
	}

	public Set<AvailableTimeTo> map2To(Set<AvailableTimeEntity> avalibleTimeEntiti) {
		return avalibleTimeEntiti.stream().map(this::map).collect(Collectors.toSet());
	}

	public Set<AvailableTimeEntity> map2Entity(Set<AvailableTimeTo> avalibleTimeDto) {
		return avalibleTimeDto.stream().map(this::map).collect(Collectors.toSet());
	}

}

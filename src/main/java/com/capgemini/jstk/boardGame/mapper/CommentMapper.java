package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.CommentDto;
import com.capgemini.jstk.boardGame.model.CommentEntiti;

@Component
public class CommentMapper {

	public CommentDto map(CommentEntiti commentEntiti) {
		if (commentEntiti != null) {
			return new CommentDto(commentEntiti.getTimeAdded(), commentEntiti.getUser(), commentEntiti.getComment());
		}
		return null;
	}

	public CommentEntiti map(CommentDto commentDto) {
		if (commentDto != null) {
			return new CommentEntiti(commentDto.getTimeAdded(), commentDto.getUser(), commentDto.getComment());
		}
		return null;
	}

	public List<CommentDto> map2To(List<CommentEntiti> commentEntiti) {
		return commentEntiti.stream().map(new CommentMapper()::map).collect(Collectors.toList());
	}

	public List<CommentEntiti> map2Entity(List<CommentDto> commentDto) {
		return commentDto.stream().map(new CommentMapper()::map).collect(Collectors.toList());
	}

}

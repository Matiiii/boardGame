package com.capgemini.jstk.boardGame.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.CommentTo;
import com.capgemini.jstk.boardGame.repository.entity.CommentEntity;

@Component
public class CommentMapper {

	public CommentTo map(CommentEntity commentEntiti) {
		if (commentEntiti != null) {
			return new CommentTo(commentEntiti.getTimeAdded(), commentEntiti.getUser(), commentEntiti.getComment());
		}
		return null;
	}

	public CommentEntity map(CommentTo commentDto) {
		if (commentDto != null) {
			return new CommentEntity(commentDto.getTimeAdded(), commentDto.getUser(), commentDto.getComment());
		}
		return null;
	}

	public List<CommentTo> map2To(List<CommentEntity> commentEntiti) {
		return commentEntiti.stream().map(this::map).collect(Collectors.toList());
	}

	public List<CommentEntity> map2Entity(List<CommentTo> commentDto) {
		return commentDto.stream().map(this::map).collect(Collectors.toList());
	}

}

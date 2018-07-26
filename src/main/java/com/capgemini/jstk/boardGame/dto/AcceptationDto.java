package com.capgemini.jstk.boardGame.dto;

import com.capgemini.jstk.boardGame.model.CommentEntiti;

public class AcceptationDto {

	private boolean acteptation;
	private CommentEntiti comment;

	public AcceptationDto() {
	}

	public AcceptationDto(boolean acteptation, CommentEntiti comment) {
		this.acteptation = acteptation;
		this.comment = comment;
	}

	public boolean isActeptation() {
		return acteptation;
	}

	public void setActeptation(boolean acteptation) {
		this.acteptation = acteptation;
	}

	public CommentEntiti getComment() {
		return comment;
	}

	public void setComment(CommentEntiti comment) {
		this.comment = comment;
	}

}

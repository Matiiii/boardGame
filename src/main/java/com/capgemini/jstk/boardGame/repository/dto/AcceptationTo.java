package com.capgemini.jstk.boardGame.repository.dto;

import com.capgemini.jstk.boardGame.repository.entity.CommentEntity;

public class AcceptationTo {

	private boolean acteptation;
	private CommentEntity comment;

	public AcceptationTo() {
	}

	public AcceptationTo(boolean acteptation, CommentEntity comment) {
		this.acteptation = acteptation;
		this.comment = comment;
	}

	public boolean isActeptation() {
		return acteptation;
	}

	public void setActeptation(boolean acteptation) {
		this.acteptation = acteptation;
	}

	public CommentEntity getComment() {
		return comment;
	}

	public void setComment(CommentEntity comment) {
		this.comment = comment;
	}

}

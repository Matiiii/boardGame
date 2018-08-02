package com.capgemini.jstk.boardGame.repository.entity;

public class AcceptationEntity {

	private boolean acteptation;
	private CommentEntity comment;

	public AcceptationEntity() {
	}

	public AcceptationEntity(boolean acteptation, CommentEntity comment) {
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

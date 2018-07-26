package com.capgemini.jstk.boardGame.model;

public class AcceptationEntiti {

	private boolean acteptation;
	private CommentEntiti comment;

	public AcceptationEntiti() {
	}

	public AcceptationEntiti(boolean acteptation, CommentEntiti comment) {
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

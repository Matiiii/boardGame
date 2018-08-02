package com.capgemini.jstk.boardGame.repository.entity;

import java.time.Instant;

public class CommentEntity {

	private Instant timeAdded;
	private UserEntity user;
	private String comment;

	public CommentEntity(Instant timeAdded, UserEntity user, String comment) {
		this.timeAdded = timeAdded;
		this.user = user;
		this.comment = comment;
	}

	public Instant getTimeAdded() {
		return timeAdded;
	}

	public void setTimeAdded(Instant timeAdded) {
		this.timeAdded = timeAdded;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

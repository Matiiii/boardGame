package com.capgemini.jstk.boardGame.repository.dto;

import java.time.Instant;

import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

public class CommentTo {

	private Instant timeAdded;
	private UserEntity user;
	private String comment;

	public CommentTo(Instant timeAdded, UserEntity user, String comment) {
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

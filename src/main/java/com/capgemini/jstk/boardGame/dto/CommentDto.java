package com.capgemini.jstk.boardGame.dto;

import java.time.Instant;

import com.capgemini.jstk.boardGame.model.UserEntiti;

public class CommentDto {

	private Instant timeAdded;
	private UserEntiti user;
	private String comment;

	public CommentDto(Instant timeAdded, UserEntiti user, String comment) {
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

	public UserEntiti getUser() {
		return user;
	}

	public void setUser(UserEntiti user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

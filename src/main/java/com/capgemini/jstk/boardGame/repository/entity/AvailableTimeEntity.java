package com.capgemini.jstk.boardGame.repository.entity;

import java.time.Instant;

public class AvailableTimeEntity {

	private Instant timeStart;
	private Instant timeStop;

	public AvailableTimeEntity() {
		super();
	}

	public AvailableTimeEntity(Instant timeStart, Instant timeStop) {
		super();
		this.timeStart = timeStart;
		this.timeStop = timeStop;
	}

	public Instant getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Instant timeStart) {
		this.timeStart = timeStart;
	}

	public Instant getTimeStop() {
		return timeStop;
	}

	public void setTimeStop(Instant timeStop) {
		this.timeStop = timeStop;
	}

}

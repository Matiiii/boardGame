package com.capgemini.jstk.boardGame.repository.dto;

import java.time.Instant;

public class AvailableTimeTo {

	private Instant timeStart;
	private Instant timeStop;

	public AvailableTimeTo(Instant timeStart, Instant timeStop) {
		super();
		this.timeStart = timeStart;
		this.timeStop = timeStop;
	}

	public AvailableTimeTo() {
		super();
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

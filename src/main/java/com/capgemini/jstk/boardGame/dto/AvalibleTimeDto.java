package com.capgemini.jstk.boardGame.dto;

import java.time.Instant;

public class AvalibleTimeDto {

	Instant timeStart;
	Instant timeStop;

	public AvalibleTimeDto(Instant timeStart, Instant timeStop) {
		super();
		this.timeStart = timeStart;
		this.timeStop = timeStop;
	}

	public AvalibleTimeDto() {
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

package com.capgemini.jstk.boardGame.model;

import java.time.Instant;

public class AvalibleTimeEntiti {

	Instant timeStart;
	Instant timeStop;

	public AvalibleTimeEntiti() {
		super();
	}

	public AvalibleTimeEntiti(Instant timeStart, Instant timeStop) {
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

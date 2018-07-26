package com.capgemini.jstk.boardGame.model;

public enum Score {
	WIN(10L), LOST(-5L), DRAW(5L), ESCAPE(-10L);

	private final Long points;

	Score(Long points) {
		this.points = points;
	}

	public Long getScore() {
		return points;
	}
}

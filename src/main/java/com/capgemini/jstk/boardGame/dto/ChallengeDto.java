package com.capgemini.jstk.boardGame.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.jstk.boardGame.model.AcceptationEntiti;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public class ChallengeDto {

	private Long id;
	private Instant timeCreated;
	private UserEntiti initializeUser;
	private Set<UserEntiti> users;
	private Map<UserEntiti, AcceptationEntiti> confirmMap;
	private AvalibleTimeEntiti proposedtime;
	private boolean isGamePlayed;
	private Map<UserEntiti, Long> scoreMap;
	private String investMessage;
	private String placeToPlay;
	private GameEntiti game;
	private List<CommentEntiti> commentList;

	public ChallengeDto() {
	}

	public ChallengeDto(Long id, Instant timeCreated, UserEntiti initializeUser, Set<UserEntiti> users,
			Map<UserEntiti, AcceptationEntiti> confirmMap, AvalibleTimeEntiti proposedtime, boolean isGamePlayed,
			Map<UserEntiti, Long> scoreMap, String investMessage, String placeToPlay, GameEntiti game,
			List<CommentEntiti> commentList) {
		this.id = id;
		this.timeCreated = timeCreated;
		this.initializeUser = initializeUser;
		this.users = users;
		this.confirmMap = confirmMap;
		this.proposedtime = proposedtime;
		this.isGamePlayed = isGamePlayed;
		this.scoreMap = scoreMap;
		this.investMessage = investMessage;
		this.placeToPlay = placeToPlay;
		this.game = game;
		this.commentList = commentList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Instant timeCreated) {
		this.timeCreated = timeCreated;
	}

	public UserEntiti getInitializeUser() {
		return initializeUser;
	}

	public void setInitializeUser(UserEntiti initializeUser) {
		this.initializeUser = initializeUser;
	}

	public Set<UserEntiti> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntiti> users) {
		this.users = users;
	}

	public Map<UserEntiti, AcceptationEntiti> getConfirmMap() {
		return confirmMap;
	}

	public void setConfirmMap(Map<UserEntiti, AcceptationEntiti> confirmMap) {
		this.confirmMap = confirmMap;
	}

	public AvalibleTimeEntiti getProposedtime() {
		return proposedtime;
	}

	public void setProposedtime(AvalibleTimeEntiti proposedtime) {
		this.proposedtime = proposedtime;
	}

	public boolean isGamePlayed() {
		return isGamePlayed;
	}

	public void setGamePlayed(boolean isGamePlayed) {
		this.isGamePlayed = isGamePlayed;
	}

	public Map<UserEntiti, Long> getScoreMap() {
		return scoreMap;
	}

	public void setScoreMap(Map<UserEntiti, Long> scoreMap) {
		this.scoreMap = scoreMap;
	}

	public String getInvestMessage() {
		return investMessage;
	}

	public void setInvestMessage(String investMessage) {
		this.investMessage = investMessage;
	}

	public String getPlaceToPlay() {
		return placeToPlay;
	}

	public void setPlaceToPlay(String placeToPlay) {
		this.placeToPlay = placeToPlay;
	}

	public GameEntiti getGame() {
		return game;
	}

	public void setGame(GameEntiti game) {
		this.game = game;
	}

	public List<CommentEntiti> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentEntiti> commentList) {
		this.commentList = commentList;
	}
}

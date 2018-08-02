package com.capgemini.jstk.boardGame.repository.entity;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChallengeEntity {

	private Long id;
	private Instant timeCreated;
	private UserEntity initializeUser;
	private Set<UserEntity> users;
	private Map<String, AcceptationEntity> confirmMap;
	private AvailableTimeEntity proposedtime;
	private boolean isGamePlayed;
	private Map<UserEntity, Long> scoreMap;
	private String investMessage;
	private String placeToPlay;
	private GameEntity game;
	private List<CommentEntity> commentList;

	public ChallengeEntity() {
	}

	public ChallengeEntity(Long id, Instant timeCreated, UserEntity initializeUser, Set<UserEntity> users,
			Map<String, AcceptationEntity> map, AvailableTimeEntity proposedtime, boolean isGamePlayed,
			Map<UserEntity, Long> scoreMap, String investMessage, String placeToPlay, GameEntity game,
			List<CommentEntity> commentList) {
		this.id = id;
		this.timeCreated = timeCreated;
		this.initializeUser = initializeUser;
		this.users = users;
		this.confirmMap = map;
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

	public UserEntity getInitializeUser() {
		return initializeUser;
	}

	public void setInitializeUser(UserEntity initializeUser) {
		this.initializeUser = initializeUser;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Map<String, AcceptationEntity> getConfirmMap() {
		return confirmMap;
	}

	public void setConfirmMap(Map<String, AcceptationEntity> confirmMap) {
		this.confirmMap = confirmMap;
	}

	public AvailableTimeEntity getProposedtime() {
		return proposedtime;
	}

	public void setProposedtime(AvailableTimeEntity proposedtime) {
		this.proposedtime = proposedtime;
	}

	public boolean isGamePlayed() {
		return isGamePlayed;
	}

	public void setGamePlayed(boolean isGamePlayed) {
		this.isGamePlayed = isGamePlayed;
	}

	public Map<UserEntity, Long> getScoreMap() {
		return scoreMap;
	}

	public void setScoreMap(Map<UserEntity, Long> scoreMap) {
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

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

	public List<CommentEntity> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentEntity> commentList) {
		this.commentList = commentList;
	}

}
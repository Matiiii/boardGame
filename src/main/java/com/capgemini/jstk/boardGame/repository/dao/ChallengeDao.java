package com.capgemini.jstk.boardGame.repository.dao;

import java.util.Set;

import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.repository.entity.AcceptationEntity;
import com.capgemini.jstk.boardGame.repository.entity.ChallengeEntity;
import com.capgemini.jstk.boardGame.repository.entity.CommentEntity;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

public interface ChallengeDao {

	Set<ChallengeEntity> findChallengesByUserFromUser(UserEntity user);

	Set<ChallengeEntity> findChallengesByUserFromSystem(UserEntity user);

	Set<ChallengeEntity> findChallengesByUserFromOtherUsers(UserEntity user);

	void addCommentToChallange(ChallengeEntity challenge, CommentEntity comment) throws NotExistChallengeException;

	void addChallenge(ChallengeEntity challenge);

	void updateChallenge(ChallengeEntity challenge) throws NotExistChallengeException;

	void confirmChallenge(UserEntity user, ChallengeEntity challenge, AcceptationEntity acceptation)
			throws NotExistChallengeException;

	Set<ChallengeEntity> findAcceptedChallengesByUser(UserEntity user);

}

package com.capgemini.jstk.boardGame.dao;

import java.util.Set;

import com.capgemini.jstk.boardGame.model.AcceptationEntiti;
import com.capgemini.jstk.boardGame.model.ChallengeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public interface ChallengeDaoInterface {

	Set<ChallengeEntiti> findChallengesByUserFromUser(UserEntiti user);

	Set<ChallengeEntiti> findChallengesByUserFromSystem(UserEntiti user);

	Set<ChallengeEntiti> findChallengesByUserFromOtherUsers(UserEntiti user);

	void addCommentToChallange(ChallengeEntiti challenge, CommentEntiti comment);

	void addChallenge(ChallengeEntiti challenge);

	void updateChallenge(ChallengeEntiti challenge);

	void confirmChallenge(UserEntiti user, ChallengeEntiti challenge, AcceptationEntiti acceptation);

}

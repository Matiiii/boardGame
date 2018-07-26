package com.capgemini.jstk.boardGame.dao;

import java.util.Set;

import com.capgemini.jstk.boardGame.model.ChallengeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public interface ChallengeDaoInterface {

	Set<ChallengeEntiti> findChallangesByUserFromUser(UserEntiti user);

	Set<ChallengeEntiti> findChallangesByUserFromSystem(UserEntiti user);

	Set<ChallengeEntiti> findChallangerByUserFromOtherUsers(UserEntiti user);

	void addCommentToChallange(ChallengeEntiti challange, CommentEntiti comment);

}

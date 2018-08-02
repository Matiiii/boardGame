package com.capgemini.jstk.boardGame.services;

import java.util.Set;

import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.repository.dto.AcceptationTo;
import com.capgemini.jstk.boardGame.repository.dto.ChallengeTo;
import com.capgemini.jstk.boardGame.repository.dto.CommentTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;

public interface ChallengeService {

	Set<ChallengeTo> findChallangesByUserFromUser(UserTo user);

	Set<ChallengeTo> findChallangesByUserFromSystem(UserTo user);

	Set<ChallengeTo> findChallangerByUserFromOtherUsers(UserTo user);

	void updateChalange(ChallengeTo challange) throws NotExistChallengeException;

	void addCommentToChalange(UserTo user, ChallengeTo challange, CommentTo comment) throws NotExistChallengeException;

	void confirmChalange(UserTo user, ChallengeTo challange, AcceptationTo acceptation)
			throws NotExistChallengeException;

	Set<ChallengeTo> findAllAcceptedChallangesByUser(UserTo user);

	boolean isCanStartGame(ChallengeTo challenge);

	void createNewChallenge(ChallengeTo challenge);

}

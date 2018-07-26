package com.capgemini.jstk.boardGame.dao.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.dao.ChallengeDaoInterface;
import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.model.ChallengeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Repository
public class ChallengeDaoImpl implements ChallengeDaoInterface {

	Set<ChallengeEntiti> challangeHistory = new HashSet<>();

	@Override
	public Set<ChallengeEntiti> findChallangesByUserFromUser(UserEntiti user) {
		return challangeHistory.stream().filter(x -> x.getInitializeUser().equals(user)).collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntiti> findChallangesByUserFromSystem(UserEntiti user) {

		return challangeHistory.stream().filter(x -> x.getInitializeUser() == null && x.getUsers().contains(user))
				.collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntiti> findChallangerByUserFromOtherUsers(UserEntiti user) {

		return challangeHistory.stream().filter(x -> x.getInitializeUser() != null && x.getUsers().contains(user)
				&& !x.getInitializeUser().equals(user)).collect(Collectors.toSet());
	}

	@Override
	public void addCommentToChallange(ChallengeEntiti challange, CommentEntiti comment)
			throws NotExistChallengeException {

		if (challangeHistory.contains(challange)) {

			challangeHistory.stream().filter(x -> x.equals(challange)).forEach(z -> z.getCommentList().add(comment));
		} else {
			throw new NotExistChallengeException();
		}
	}

}

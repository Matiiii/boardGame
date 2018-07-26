package com.capgemini.jstk.boardGame.dao.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.dao.ChallengeDaoInterface;
import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.mapper.ChallengeMapper;
import com.capgemini.jstk.boardGame.model.AcceptationEntiti;
import com.capgemini.jstk.boardGame.model.ChallengeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Repository
public class ChallengeDaoImpl implements ChallengeDaoInterface {

	Set<ChallengeEntiti> challangeHistory = new HashSet<>();

	@Autowired
	ChallengeMapper challengeMapper;

	@Autowired
	MockDataInitializer mockDataInitializer;

	@PostConstruct
	private void init() {
		challangeHistory.add(challengeMapper.map(mockDataInitializer.challengeDto1));
		challangeHistory.add(challengeMapper.map(mockDataInitializer.challengeDto2));
	}

	@Override
	public Set<ChallengeEntiti> findChallengesByUserFromUser(UserEntiti user) {
		return challangeHistory.stream().filter(x -> x.getInitializeUser().getUserName().equals(user.getUserName()))
				.collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntiti> findChallengesByUserFromSystem(UserEntiti user) {

		return challangeHistory.stream().filter(x -> x.getInitializeUser() == null && x.getUsers().contains(user))
				.collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntiti> findChallengesByUserFromOtherUsers(UserEntiti user) {

		return challangeHistory.stream().filter(x -> x.getInitializeUser() != null && x.getUsers().contains(user)
				&& !x.getInitializeUser().equals(user)).collect(Collectors.toSet());
	}

	@Override
	public void addCommentToChallange(ChallengeEntiti challenge, CommentEntiti comment)
			throws NotExistChallengeException {

		if (challangeHistory.stream().anyMatch(x -> x.getId().equals(challenge.getId()))) {

			challangeHistory.stream().filter(x -> x.getId().equals(challenge.getId()))
					.forEach(z -> z.getCommentList().add(comment));
		} else {
			throw new NotExistChallengeException();
		}
	}

	@Override
	public void addChallenge(ChallengeEntiti challenge) {
		challangeHistory.add(challenge);

	}

	@Override
	public void updateChallenge(ChallengeEntiti challenge) {

		if (challangeHistory.removeIf(x -> x.getId().equals(challenge.getId()))) {
			challangeHistory.add(challenge);
		} else {
			throw new NotExistChallengeException();
		}

	}

	@Override
	public void confirmChallenge(UserEntiti user, ChallengeEntiti challenge, AcceptationEntiti acceptation) {

		if (challangeHistory.stream().anyMatch(x -> x.getId().equals(challenge.getId()))) {
			challangeHistory.stream().filter(x -> x.getId().equals(challenge.getId()))
					.forEach(y -> y.getConfirmMap().put(user.getUserName(), acceptation));
		} else {
			throw new NotExistChallengeException();
		}

	}

	@Override
	public Set<ChallengeEntiti> findAcceptedChallengesByUser(UserEntiti user) {

		return challangeHistory.stream()
				.filter(x -> x.getUsers().stream().anyMatch(y -> y.getUserName().equals(user.getUserName()))
						&& x.getConfirmMap().get(user.getUserName()).isActeptation() == true)
				.collect(Collectors.toSet());
	}

}

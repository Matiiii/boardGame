package com.capgemini.jstk.boardGame.repository.dao.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardGame.MockDataInitializer;
import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.mapper.ChallengeMapper;
import com.capgemini.jstk.boardGame.repository.dao.ChallengeDao;
import com.capgemini.jstk.boardGame.repository.entity.AcceptationEntity;
import com.capgemini.jstk.boardGame.repository.entity.ChallengeEntity;
import com.capgemini.jstk.boardGame.repository.entity.CommentEntity;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	Set<ChallengeEntity> challengeHistory = new HashSet<>();

	@Autowired
	ChallengeMapper challengeMapper;

	@Autowired
	MockDataInitializer mockDataInitializer;

	@PostConstruct
	private void init() {
		challengeHistory.add(challengeMapper.map(mockDataInitializer.challengeDto1));
		challengeHistory.add(challengeMapper.map(mockDataInitializer.challengeDto2));
	}

	@Override
	public Set<ChallengeEntity> findChallengesByUserFromUser(UserEntity user) {
		return challengeHistory.stream().filter(x -> x.getInitializeUser().getUserName().equals(user.getUserName()))
				.collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntity> findChallengesByUserFromSystem(UserEntity user) {

		return challengeHistory.stream().filter(x -> x.getInitializeUser() == null && x.getUsers().contains(user))
				.collect(Collectors.toSet());

	}

	@Override
	public Set<ChallengeEntity> findChallengesByUserFromOtherUsers(UserEntity user) {

		return challengeHistory.stream().filter(x -> x.getInitializeUser() != null && x.getUsers().contains(user)
				&& !x.getInitializeUser().equals(user)).collect(Collectors.toSet());
	}

	@Override
	public void addCommentToChallange(ChallengeEntity challenge, CommentEntity comment)
			throws NotExistChallengeException {

		if (challengeHistory.stream().anyMatch(x -> x.getId().equals(challenge.getId()))) {

			challengeHistory.stream().filter(x -> x.getId().equals(challenge.getId()))
					.forEach(z -> z.getCommentList().add(comment));
		} else {
			throw new NotExistChallengeException();
		}
	}

	@Override
	public void addChallenge(ChallengeEntity challenge) {
		challengeHistory.add(challenge);

	}

	@Override
	public void updateChallenge(ChallengeEntity challenge) throws NotExistChallengeException {

		if (challengeHistory.removeIf(x -> x.getId().equals(challenge.getId()))) {
			challengeHistory.add(challenge);
		} else {
			throw new NotExistChallengeException();
		}

	}

	@Override
	public void confirmChallenge(UserEntity user, ChallengeEntity challenge, AcceptationEntity acceptation)
			throws NotExistChallengeException {

		if (challengeHistory.stream().anyMatch(x -> x.getId().equals(challenge.getId()))) {
			challengeHistory.stream().filter(x -> x.getId().equals(challenge.getId()))
					.forEach(y -> y.getConfirmMap().put(user.getUserName(), acceptation));
		} else {
			throw new NotExistChallengeException();
		}

	}

	@Override
	public Set<ChallengeEntity> findAcceptedChallengesByUser(UserEntity user) {

		return challengeHistory.stream()
				.filter(x -> x.getUsers().stream().anyMatch(y -> y.getUserName().equals(user.getUserName()))
						&& x.getConfirmMap().get(user.getUserName()).isActeptation() == true)
				.collect(Collectors.toSet());
	}

}

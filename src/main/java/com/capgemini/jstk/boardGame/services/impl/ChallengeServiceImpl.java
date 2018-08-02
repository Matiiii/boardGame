package com.capgemini.jstk.boardGame.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.mapper.AcceptationMapper;
import com.capgemini.jstk.boardGame.mapper.ChallengeMapper;
import com.capgemini.jstk.boardGame.mapper.CommentMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.repository.dao.ChallengeDao;
import com.capgemini.jstk.boardGame.repository.dto.AcceptationTo;
import com.capgemini.jstk.boardGame.repository.dto.ChallengeTo;
import com.capgemini.jstk.boardGame.repository.dto.CommentTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;
import com.capgemini.jstk.boardGame.services.ChallengeService;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	private ChallengeDao challengeDao;

	private ChallengeMapper challengeMaper;

	private UserMapper userMapper;

	private CommentMapper commentMapper;

	private AcceptationMapper acceptationMapper;

	@Autowired
	public ChallengeServiceImpl(ChallengeDao challengeDao, ChallengeMapper challengeMaper, UserMapper userMapper,
			CommentMapper commentMapper, AcceptationMapper acceptationMapper) {
		this.challengeDao = challengeDao;
		this.challengeMaper = challengeMaper;
		this.userMapper = userMapper;
		this.commentMapper = commentMapper;
		this.acceptationMapper = acceptationMapper;
	}

	@Override
	public Set<ChallengeTo> findChallangesByUserFromUser(UserTo user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromUser(userMapper.map(user)));
	}

	@Override
	public Set<ChallengeTo> findChallangesByUserFromSystem(UserTo user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromSystem(userMapper.map(user)));
	}

	@Override
	public Set<ChallengeTo> findChallangerByUserFromOtherUsers(UserTo user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromOtherUsers(userMapper.map(user)));
	}

	@Override
	public void updateChalange(ChallengeTo challange) throws NotExistChallengeException {

		challengeDao.updateChallenge(challengeMaper.map(challange));

	}

	@Override
	public void addCommentToChalange(UserTo user, ChallengeTo challange, CommentTo comment)
			throws NotExistChallengeException {

		challengeDao.addCommentToChallange(challengeMaper.map(challange), commentMapper.map(comment));

	}

	@Override
	public void confirmChalange(UserTo user, ChallengeTo challenge, AcceptationTo acceptation)
			throws NotExistChallengeException {

		challengeDao.confirmChallenge(userMapper.map(user), challengeMaper.map(challenge),
				acceptationMapper.map(acceptation));

	}

	@Override
	public boolean isCanStartGame(ChallengeTo challenge) {

		return false;
	}

	@Override
	public void createNewChallenge(ChallengeTo challenge) {
		challengeDao.addChallenge(challengeMaper.map(challenge));

	}

	@Override
	public Set<ChallengeTo> findAllAcceptedChallangesByUser(UserTo user) {

		return challengeMaper.map2To(challengeDao.findAcceptedChallengesByUser(userMapper.map(user)));
	}

}

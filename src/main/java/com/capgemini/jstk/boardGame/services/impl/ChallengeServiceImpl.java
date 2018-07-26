package com.capgemini.jstk.boardGame.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardGame.dao.ChallengeDaoInterface;
import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.dto.CommentDto;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.mapper.AcceptationMapper;
import com.capgemini.jstk.boardGame.mapper.ChallengeMapper;
import com.capgemini.jstk.boardGame.mapper.CommentMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.services.ChallengeServiceInterface;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {

	private ChallengeDaoInterface challengeDao;

	private ChallengeMapper challengeMaper;

	private UserMapper userMapper;

	private CommentMapper commentMapper;

	private AcceptationMapper acceptationMapper;

	@Autowired
	public ChallengeServiceImpl(ChallengeDaoInterface challengeDao, ChallengeMapper challengeMaper,
			UserMapper userMapper, CommentMapper commentMapper, AcceptationMapper acceptationMapper) {
		this.challengeDao = challengeDao;
		this.challengeMaper = challengeMaper;
		this.userMapper = userMapper;
		this.commentMapper = commentMapper;
		this.acceptationMapper = acceptationMapper;
	}

	@Override
	public Set<ChallengeDto> findChallangesByUserFromUser(UserDto user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromUser(userMapper.map(user)));
	}

	@Override
	public Set<ChallengeDto> findChallangesByUserFromSystem(UserDto user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromSystem(userMapper.map(user)));
	}

	@Override
	public Set<ChallengeDto> findChallangerByUserFromOtherUsers(UserDto user) {

		return challengeMaper.map2To(challengeDao.findChallengesByUserFromOtherUsers(userMapper.map(user)));
	}

	@Override
	public void updateChalange(ChallengeDto challange) {

		challengeDao.updateChallenge(challengeMaper.map(challange));

	}

	@Override
	public void addCommentToChalange(UserDto user, ChallengeDto challange, CommentDto comment) {

		challengeDao.addCommentToChallange(challengeMaper.map(challange), commentMapper.map(comment));

	}

	@Override
	public void confirmChalange(UserDto user, ChallengeDto challenge, AcceptationDto acceptation) {

		challengeDao.confirmChallenge(userMapper.map(user), challengeMaper.map(challenge),
				acceptationMapper.map(acceptation));

	}

	@Override
	public boolean isCanStartGame(ChallengeDto challenge) {

		return false;
	}

	@Override
	public void createNewChallenge(ChallengeDto challenge) {
		challengeDao.addChallenge(challengeMaper.map(challenge));

	}

	@Override
	public Set<ChallengeDto> findAllAcceptedChallangesByUser(UserDto user) {

		return challengeMaper.map2To(challengeDao.findAcceptedChallengesByUser(userMapper.map(user)));
	}

}

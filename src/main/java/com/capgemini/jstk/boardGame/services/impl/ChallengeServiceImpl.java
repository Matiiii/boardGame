package com.capgemini.jstk.boardGame.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardGame.dao.ChallengeDaoInterface;
import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.dto.CommentDto;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.mapper.ChallengeMapper;
import com.capgemini.jstk.boardGame.model.UserEntiti;
import com.capgemini.jstk.boardGame.services.ChallengeServiceInterface;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {

	private ChallengeDaoInterface challengeDao;

	private ChallengeMapper challengeMaper;

	@Autowired
	public ChallengeServiceImpl(ChallengeDaoInterface challangeDao, ChallengeMapper challangeMaper) {
		this.challengeDao = challangeDao;
		this.challengeMaper = challangeMaper;
	}

	@Override
	public Set<ChallengeDto> findChallangesByUserFromUser(UserDto user) {

		return challengeMaper.map2To(challengeDao.findChallangesByUserFromUser(user));
	}

	@Override
	public Set<ChallengeDto> findChallangesByUserFromSystem(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ChallengeDto> findChallangerByUserFromOtherUsers(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateChalange(ChallengeDto challange) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCommentToChalange(UserDto user, ChallengeDto challange, CommentDto comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmChalange(UserDto user, ChallengeDto challange, AcceptationDto acceptation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ChallengeDto> findAllAcceptedChallangesByUser(UserEntiti user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCanStartGame(ChallengeDto challange) {
		// TODO Auto-generated method stub
		return false;
	}

}

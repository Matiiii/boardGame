package com.capgemini.jstk.boardGame.services;

import java.util.Set;

import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.dto.CommentDto;
import com.capgemini.jstk.boardGame.dto.UserDto;

public interface ChallengeServiceInterface {

	Set<ChallengeDto> findChallangesByUserFromUser(UserDto user);

	Set<ChallengeDto> findChallangesByUserFromSystem(UserDto user);

	Set<ChallengeDto> findChallangerByUserFromOtherUsers(UserDto user);

	void updateChalange(ChallengeDto challange);

	void addCommentToChalange(UserDto user, ChallengeDto challange, CommentDto comment);

	void confirmChalange(UserDto user, ChallengeDto challange, AcceptationDto acceptation);

	Set<ChallengeDto> findAllAcceptedChallangesByUser(UserDto user);

	boolean isCanStartGame(ChallengeDto challenge);

	void createNewChallenge(ChallengeDto challenge);

}

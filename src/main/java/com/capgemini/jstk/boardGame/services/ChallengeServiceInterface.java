package com.capgemini.jstk.boardGame.services;

import java.util.List;
import java.util.Set;

import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.dto.CommentDto;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public interface ChallengeServiceInterface {

	Set<ChallengeDto> findChallangesByUserFromUser(UserDto user);

	Set<ChallengeDto> findChallangesByUserFromSystem(UserDto user);

	Set<ChallengeDto> findChallangerByUserFromOtherUsers(UserDto user);

	void updateChalange(ChallengeDto challange);

	void addCommentToChalange(UserDto user, ChallengeDto challange, CommentDto comment);

	void confirmChalange(UserDto user, ChallengeDto challange, AcceptationDto acceptation);

	List<ChallengeDto> findAllAcceptedChallangesByUser(UserEntiti user);

	boolean isCanStartGame(ChallengeDto challange);

}

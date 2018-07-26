package com.capgemini.jstk.boardGame.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.model.ChallengeEntiti;

@Component
public class ChallengeMapper {

	public ChallengeDto map(ChallengeEntiti challangeEntiti) {
		if (challangeEntiti != null) {
			return new ChallengeDto(challangeEntiti.getId(), challangeEntiti.getTimeCreated(),
					challangeEntiti.getInitializeUser(), challangeEntiti.getUsers(), challangeEntiti.getConfirmMap(),
					challangeEntiti.getProposedtime(), challangeEntiti.isGamePlayed(), challangeEntiti.getScoreMap(),
					challangeEntiti.getInvestMessage(), challangeEntiti.getPlaceToPlay(), challangeEntiti.getGame(),
					challangeEntiti.getCommentList());
		}
		return null;
	}

	public ChallengeEntiti map(ChallengeDto challangeDto) {
		if (challangeDto != null) {
			return new ChallengeEntiti(challangeDto.getId(), challangeDto.getTimeCreated(),
					challangeDto.getInitializeUser(), challangeDto.getUsers(), challangeDto.getConfirmMap(),
					challangeDto.getProposedtime(), challangeDto.isGamePlayed(), challangeDto.getScoreMap(),
					challangeDto.getInvestMessage(), challangeDto.getPlaceToPlay(), challangeDto.getGame(),
					challangeDto.getCommentList());
		}
		return null;
	}

	public Set<ChallengeDto> map2To(Set<ChallengeEntiti> challangeEntiti) {
		return challangeEntiti.stream().map(new ChallengeMapper()::map).collect(Collectors.toSet());
	}

	public Set<ChallengeEntiti> map2Entity(Set<ChallengeDto> challangeDto) {
		return challangeDto.stream().map(new ChallengeMapper()::map).collect(Collectors.toSet());
	}

}

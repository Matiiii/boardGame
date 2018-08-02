package com.capgemini.jstk.boardGame.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.ChallengeTo;
import com.capgemini.jstk.boardGame.repository.entity.ChallengeEntity;

@Component
public class ChallengeMapper {

	public ChallengeTo map(ChallengeEntity challangeEntiti) {
		if (challangeEntiti != null) {
			return new ChallengeTo(challangeEntiti.getId(), challangeEntiti.getTimeCreated(),
					challangeEntiti.getInitializeUser(), challangeEntiti.getUsers(), challangeEntiti.getConfirmMap(),
					challangeEntiti.getProposedtime(), challangeEntiti.isGamePlayed(), challangeEntiti.getScoreMap(),
					challangeEntiti.getInvestMessage(), challangeEntiti.getPlaceToPlay(), challangeEntiti.getGame(),
					challangeEntiti.getCommentList());
		}
		return null;
	}

	public ChallengeEntity map(ChallengeTo challangeDto) {
		if (challangeDto != null) {
			return new ChallengeEntity(challangeDto.getId(), challangeDto.getTimeCreated(),
					challangeDto.getInitializeUser(), challangeDto.getUsers(), challangeDto.getConfirmMap(),
					challangeDto.getProposedtime(), challangeDto.isGamePlayed(), challangeDto.getScoreMap(),
					challangeDto.getInvestMessage(), challangeDto.getPlaceToPlay(), challangeDto.getGame(),
					challangeDto.getCommentList());
		}
		return null;
	}

	public Set<ChallengeTo> map2To(Set<ChallengeEntity> challangeEntiti) {
		return challangeEntiti.stream().map(this::map).collect(Collectors.toSet());
	}

	public Set<ChallengeEntity> map2Entity(Set<ChallengeTo> challangeDto) {
		return challangeDto.stream().map(this::map).collect(Collectors.toSet());
	}

}

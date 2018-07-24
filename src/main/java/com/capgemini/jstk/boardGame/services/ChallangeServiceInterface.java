package com.capgemini.jstk.boardGame.services;

import java.util.List;

import com.capgemini.jstk.boardGame.model.ChallangeEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public interface ChallangeServiceInterface {

	List<ChallangeEntiti> findChallangesByUserFromUser(UserEntiti user);

	List<ChallangeEntiti> findChallangesByUserFromSystem(UserEntiti user);

	List<ChallangeEntiti> findChallangerByUserFromOtherUsers(UserEntiti user);
}

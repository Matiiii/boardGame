package com.capgemini.jstk.boardGame.model;

import java.util.Map;
import java.util.Set;

public class ChallangeEntiti {
	Long id;

	UserEntiti initializeUser;
	Set<UserEntiti> users;
	Map<UserEntiti, Boolean> confirmMap;
	Map<UserEntiti, Score> scoreMap;

}
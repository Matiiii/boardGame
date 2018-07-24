package com.capgemini.jstk.boardGame.model;

import java.util.Set;

public class UserEntiti {

	Long id;

	String name;
	String surname;
	String motto;

	Set<GameEntiti> ownGames;
	Set<AvalibleTimeEntiti> avalible;

}

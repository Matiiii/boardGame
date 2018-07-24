package com.capgemini.jstk.boardGame.dao;

import java.util.Set;

import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

public interface UserDaoInterface {
	Set<UserEntiti> getUsersByGame(GameEntiti game);

}

package com.capgemini.jstk.boardGame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardGame.dao.impl.GameDaoImpl;
import com.capgemini.jstk.boardGame.dao.impl.UserDaoImpl;
import com.capgemini.jstk.boardGame.model.UserEntiti;
import com.capgemini.jstk.boardGame.services.UserServiceInterface;

@SuppressWarnings({ "deprecation" })
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	MockDataInitializer mockdata;

	@InjectMocks
	UserServiceInterface userService;

	@Mock
	UserDaoImpl userDao;

	@Mock
	GameDaoImpl gameDao;

	@Before
	public void setUp() {
		Set<UserEntiti> someSet = new HashSet<>();
		UserEntiti user1 = (UserEntiti) mockdata.user1;

		Mockito.when(userDao.getUserByUserName(Mockito.anyString())).thenReturn(someSet.add(user1));

		Mockito.when(userDao.getUsersByGame(Mockito.anyString())).thenReturn();
	}

	@Test
	public void shouldReturnPlayer() {
		// given
		// when
		userService.findUsersByBasicInformation("Mati");
		// then
		Mockito.verify().size();
	}

	@Test
	public void shouldAddPlayer() {
		// given
		// when
		userService.addUser(mockdata.user2);
		// then
		Mockito.verify(userDao).addUser(Mockito.any());
	}

	@Test
	public void shouldReturnPlayerInfo() {
		// given
		// when
		userService.findUsersByBasicInformation("Sroka");
		// then
		Mockito.verify(userDao.getUserByUserName(Mockito.anyString()));
	}

	@Test
	public void shouldSearchPlayersByRank() {

	}
}

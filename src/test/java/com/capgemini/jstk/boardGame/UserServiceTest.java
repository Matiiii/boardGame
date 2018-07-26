package com.capgemini.jstk.boardGame;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardGame.dao.impl.GameDaoImpl;
import com.capgemini.jstk.boardGame.dao.impl.UserDaoImpl;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.model.UserEntiti;
import com.capgemini.jstk.boardGame.services.impl.UserServiceImpl;

@SuppressWarnings({ "deprecation" })
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	MockDataInitializer mockdata;

	@InjectMocks
	UserServiceImpl userService;
	@Spy
	UserMapper usermapper;
	@Mock
	UserDaoImpl userDao;

	@Mock
	GameDaoImpl gameDao;

	@Before
	public void setUp() {
		Set<UserEntiti> someSet = new HashSet<>();
		UserEntiti user1 = (UserEntiti) mockdata.user1;
		someSet.add(user1);

		Mockito.when(userDao.getUserByUserName(Mockito.anyString())).thenReturn(someSet);

		// Mockito.when(userDao.getUsersByGame(Mockito.anyString())).thenReturn();
	}

	@Test
	public void shouldReturnPlayer() {
		// given
		// when

		assertTrue(
				userService.findUsersByBasicInformation("Mati").stream().anyMatch(x -> x.getUserName().equals("Mati")));
		// then

	}

	/*
	 * @Test public void shouldAddPlayer() { // given // when //
	 * userService.addUser(mockdata.user2); // then
	 * Mockito.verify(userDao).addUser(Mockito.any()); }
	 */

	/*
	 * @Test public void shouldReturnPlayerInfo() { // given // when
	 * userService.findUsersByBasicInformation("Sroka"); // then
	 * Mockito.verify(userDao.getUserByUserName(Mockito.anyString())); }
	 */

}

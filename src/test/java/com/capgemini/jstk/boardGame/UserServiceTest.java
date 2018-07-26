package com.capgemini.jstk.boardGame;

import static org.junit.Assert.assertFalse;
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

import com.capgemini.jstk.boardGame.dao.impl.UserDaoImpl;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.mapper.AvalibleTimeMapper;
import com.capgemini.jstk.boardGame.mapper.GameMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;
import com.capgemini.jstk.boardGame.services.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	MockDataInitializer mockdata;

	@InjectMocks
	UserServiceImpl userService;

	@Spy
	UserMapper usermapper;

	@Spy
	GameMapper gameMapper;

	@Spy
	AvalibleTimeMapper avalibleTimeMapper;

	@Mock
	UserDaoImpl userDao;

	@Before
	public void setUp() {
		Set<UserEntiti> entitiSet = new HashSet<>();
		Set<UserEntiti> entitiSet2 = new HashSet<>();
		UserEntiti user5 = mockdata.user5;
		UserEntiti user4 = mockdata.user4;
		Set<UserDto> dtoSet = new HashSet<>();
		UserDto user6 = mockdata.user6Dto;
		dtoSet.add(user6);
		entitiSet.add(user5);
		entitiSet2.add(user4);

		Mockito.when(userDao.getUserByUserName(Mockito.anyString())).thenReturn(entitiSet);

		Mockito.when(userDao.getUsersByGame(Mockito.any(GameEntiti.class))).thenReturn(entitiSet);

		Mockito.when(userDao.getUserByUserEmail(Mockito.anyString())).thenReturn(entitiSet2);

		Mockito.when(userDao.getUserByAvalible(Mockito.any(AvalibleTimeEntiti.class))).thenReturn(entitiSet);

	}

	@Test
	public void shouldReturnCorrectPlayer() {

		// given
		// when

		assertTrue(userService.findUsersByBasicInformation("Bohdan").stream()
				.anyMatch(x -> x.getUserName().equals("Bohdan")));

		assertTrue(userService.findUsersByBasicInformation("patrycja.kulfon@gmail.pl").stream()
				.anyMatch(x -> x.getEmail().equals("patrycja.kulfon@gmail.pl")));

		assertFalse(userService.findUsersByBasicInformation("Mariusz@mariusz.pl").stream()
				.anyMatch(x -> x.getEmail().equals("Mariusz@mariusz.pl")));
		// then

	}

	@Test
	public void shouldReturnCorrectPlayer2() {

		assertTrue(userService.findUsersByGame(mockdata.gameDto1).stream()
				.anyMatch(x -> x.getUserName().equals("Bohdan")));

		assertFalse(userService.findUsersByGame(mockdata.gameDto1).stream()
				.anyMatch(x -> x.getEmail().equals("Mariusz@mariusz.pl")));

	}

	@Test
	public void shouldSearchPlayersByGame() {
		// given

		// when
		userService.findUsersByGame(mockdata.gameDto1);
		// then
		Mockito.verify(userDao).getUsersByGame(Mockito.any());
	}

	@Test
	public void shouldReturnCorrectPlayer3() {

		assertTrue(userService.findUserSByAvalibleTime(mockdata.timeDto1).stream()
				.anyMatch(x -> x.getUserName().equals("Bohdan")));

		assertFalse(userService.findUserSByAvalibleTime(mockdata.timeDto1).stream()
				.anyMatch(x -> x.getEmail().equals("Mariusz@mariusz.pl")));

	}

	@Test
	public void shouldSearchPlayersByAvalible() {
		// given

		// when
		userService.findUserSByAvalibleTime(mockdata.timeDto1);
		// then
		Mockito.verify(userDao).getUserByAvalible(Mockito.any());
	}

}

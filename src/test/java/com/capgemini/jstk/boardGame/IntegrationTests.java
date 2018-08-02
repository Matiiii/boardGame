package com.capgemini.jstk.boardGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardGame.exceptions.NotExistChallengeException;
import com.capgemini.jstk.boardGame.exceptions.UserNotExistException;
import com.capgemini.jstk.boardGame.mapper.GameMapper;
import com.capgemini.jstk.boardGame.mapper.UserMapper;
import com.capgemini.jstk.boardGame.repository.dao.impl.ChallengeDaoImpl;
import com.capgemini.jstk.boardGame.repository.dto.AvailableTimeTo;
import com.capgemini.jstk.boardGame.services.ChallengeService;
import com.capgemini.jstk.boardGame.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@EnableAspectJAutoProxy
public class IntegrationTests {

	@Autowired
	MockDataInitializer mockdata;

	@Autowired
	UserMapper userMapper;

	@Autowired
	GameMapper gameMapper;

	@Autowired
	ChallengeDaoImpl challengeDaoImpl;

	@Autowired
	private ChallengeService challengeService;

	@Autowired
	private UserService userService;

	@Test
	public void schouldGetUser() throws UserNotExistException {

		assertTrue(
				userService.findUsersByBasicInformation("Mati").stream().anyMatch(x -> x.getUserName().equals("Mati")));

	}

	@Test
	public void schouldAddUser() throws UserNotExistException {
		userService.addUser(mockdata.user6Dto);

		assertEquals("Mariusz", userService.getUserByName("Mariusz").getUserName());

	}

	@Test
	public void schouldGiveListOf4Users() {
		assertEquals(4, userService.findUsersByGame(gameMapper.map(mockdata.game2)).size());
	}

	@Test
	public void schouldGiveListOf2AvalibleUsers() {
		assertEquals(2, userService.findUsersByAvailableTime(
				new AvailableTimeTo(Instant.parse("2018-08-25T12:15:30.00Z"), Instant.parse("2018-08-25T15:15:30.00Z")))
				.size());
	}

	@Test
	public void schouldAddAcceptationToChallange() throws NotExistChallengeException {
		challengeService.confirmChalange(userMapper.map(mockdata.user1), mockdata.challengeDto1,
				mockdata.acceptationDto1);

		challengeService.confirmChalange(userMapper.map(mockdata.user2), mockdata.challengeDto1,
				mockdata.acceptationDto1);

		challengeService.confirmChalange(userMapper.map(mockdata.user3), mockdata.challengeDto1,
				mockdata.acceptationDto1);

		// assertEquals(1,
		// challengeService.findAllAcceptedChallangesByUser(userMapper.map(mockdata.user3)).size());

	}

}

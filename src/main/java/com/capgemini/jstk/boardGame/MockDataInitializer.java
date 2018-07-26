package com.capgemini.jstk.boardGame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.AcceptationDto;
import com.capgemini.jstk.boardGame.dto.AvalibleTimeDto;
import com.capgemini.jstk.boardGame.dto.ChallengeDto;
import com.capgemini.jstk.boardGame.dto.GameDto;
import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Component
public class MockDataInitializer {

	Set<UserEntiti> setUsersEntiti = new HashSet<>();

	public ChallengeDto challengeDto1 = new ChallengeDto();
	public ChallengeDto challengeDto2 = new ChallengeDto();
	public ChallengeDto challengeDto3 = new ChallengeDto();

	public AvalibleTimeEntiti time1 = new AvalibleTimeEntiti(Instant.parse("2018-08-25T10:15:30.00Z"),
			Instant.parse("2018-08-26T10:15:30.00Z"));
	public AvalibleTimeEntiti time2 = new AvalibleTimeEntiti(Instant.parse("2018-08-26T10:15:30.00Z"),
			Instant.parse("2018-08-26T15:15:30.00Z"));
	public AvalibleTimeEntiti time3 = new AvalibleTimeEntiti(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-10T14:15:30.00Z"));
	public AvalibleTimeEntiti time4 = new AvalibleTimeEntiti(Instant.parse("2018-08-05T10:15:30.00Z"),
			Instant.parse("2018-08-05T10:15:30.00Z"));
	public AvalibleTimeEntiti time5 = new AvalibleTimeEntiti(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-12T10:15:30.00Z"));

	public AvalibleTimeDto timeDto1 = new AvalibleTimeDto(Instant.parse("2018-08-25T10:15:30.00Z"),
			Instant.parse("2018-08-26T10:15:30.00Z"));
	public AvalibleTimeDto timeDto2 = new AvalibleTimeDto(Instant.parse("2018-08-26T10:15:30.00Z"),
			Instant.parse("2018-08-26T15:15:30.00Z"));
	public AvalibleTimeDto timeDto3 = new AvalibleTimeDto(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-10T14:15:30.00Z"));
	public AvalibleTimeDto timeDto4 = new AvalibleTimeDto(Instant.parse("2018-08-05T10:15:30.00Z"),
			Instant.parse("2018-08-05T10:15:30.00Z"));
	public AvalibleTimeDto timeDto5 = new AvalibleTimeDto(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-12T10:15:30.00Z"));

	public GameEntiti game1 = new GameEntiti("Wyscig szczurow", 2, 6);
	public GameEntiti game2 = new GameEntiti("Szachy", 2, 2);
	public GameEntiti game3 = new GameEntiti("Magic", 2, 2);
	public GameEntiti game4 = new GameEntiti("Super Ściemniacz", 2, 8);

	public GameDto gameDto1 = new GameDto("Wyscig szczurow", 2, 6);
	public GameDto gameDto2 = new GameDto("Warcaby", 2, 2);
	public GameDto gameDto3 = new GameDto("dddddd", 2, 2);
	public GameDto gameDto4 = new GameDto("Solą do oka", 2, 8);

	public UserEntiti user1 = new UserEntiti();
	public UserEntiti user2 = new UserEntiti();
	public UserEntiti user3 = new UserEntiti();
	public UserEntiti user4 = new UserEntiti();
	public UserEntiti user5 = new UserEntiti();

	public UserDto user6Dto = new UserDto();
	public UserDto user7Dto = new UserDto();
	public UserDto user8Dto = new UserDto();
	public UserDto user9Dto = new UserDto();
	public UserDto user10Dto = new UserDto();

	@PostConstruct
	public List<UserEntiti> createMokksUsersList() {

		challengeDto1.setId(1l);
		challengeDto1.setCommentList(new ArrayList<CommentEntiti>());
		challengeDto1.setConfirmMap(new HashMap<>());
		challengeDto1.setGame(game1);
		challengeDto1.setGamePlayed(false);
		challengeDto1.setInitializeUser(user1);
		challengeDto1.setInvestMessage("Hallo");
		challengeDto1.setPlaceToPlay("Moje lokum");
		challengeDto1.setProposedtime(time1);
		challengeDto1.setScoreMap(new HashMap<>());
		challengeDto1.setTimeCreated(Instant.parse("2018-08-25T10:15:30.00Z"));
		challengeDto1.setUsers(setUsersEntiti);

		challengeDto2.setId(2L);
		challengeDto2.setCommentList(new ArrayList<CommentEntiti>());
		challengeDto2.setConfirmMap(new HashMap<>());
		challengeDto2.setGame(game2);
		challengeDto2.setGamePlayed(false);
		challengeDto2.setInitializeUser(user2);
		challengeDto2.setInvestMessage("Hallo moto");
		challengeDto2.setPlaceToPlay("knajpa ");
		challengeDto2.setProposedtime(time2);
		challengeDto2.setScoreMap(new HashMap<>());
		challengeDto2.setTimeCreated(Instant.parse("2018-08-27T10:15:30.00Z"));
		challengeDto2.setUsers(setUsersEntiti);

		challengeDto3.setId(3L);
		challengeDto3.setCommentList(new ArrayList<CommentEntiti>());
		challengeDto3.setConfirmMap(new HashMap<>());
		challengeDto3.setGame(game3);
		challengeDto3.setGamePlayed(true);
		challengeDto3.setInitializeUser(user3);
		challengeDto3.setInvestMessage("Mo Faja");
		challengeDto3.setPlaceToPlay("Mieszkanie ");
		challengeDto3.setProposedtime(time3);
		challengeDto3.setScoreMap(new HashMap<>());
		challengeDto3.setTimeCreated(Instant.parse("2018-08-29T10:15:30.00Z"));
		challengeDto3.setUsers(setUsersEntiti);

		List<UserEntiti> userList = new ArrayList<>();

		user1.setUserName("Mati");
		user1.setEmail("mati@mati.pl");
		user1.getAvalible().add(time1);
		user1.getAvalible().add(time2);
		user1.addGame(game1);
		user1.addGame(game2);
		user1.addGame(game3);

		userList.add(user1);

		user2.setUserName("Bartosh");
		user2.setEmail("mokrybartii@onet.pl");
		user2.getAvalible().add(time2);
		user2.getAvalible().add(time4);
		user2.addGame(game3);
		user2.addGame(game2);
		user2.addGame(game4);

		userList.add(user2);

		user3.setUserName("Stasiiiix");
		user3.setEmail("stasiapodpasia@gmail.com");
		user3.getAvalible().add(time2);
		user3.getAvalible().add(time5);
		user3.addGame(game3);

		userList.add(user3);

		user4.setUserName("PaTrYcJa");
		user4.setEmail("patrycja.kulfon@gmail.pl");
		user4.getAvalible().add(time2);
		user4.getAvalible().add(time4);
		user4.addGame(game3);
		user4.addGame(game2);
		user4.addGame(game4);

		userList.add(user4);

		user5.setUserName("Bohdan");
		user5.setEmail("prezny@sympatia.pl");
		user5.getAvalible().add(time2);
		user5.addGame(game2);
		user5.addGame(game4);

		user6Dto.setUserName("Mariusz");
		user6Dto.setEmail("mariusz@mati.pl");
		user6Dto.getAvalible().add(time1);
		user6Dto.getAvalible().add(time2);
		user6Dto.addGame(game1);
		user6Dto.addGame(game2);
		user6Dto.addGame(game3);

		user7Dto.setUserName("Barabara");
		user7Dto.setEmail("booblebody@onet.pl");
		user7Dto.getAvalible().add(time2);
		user7Dto.getAvalible().add(time4);
		user7Dto.addGame(game3);
		user7Dto.addGame(game2);
		user7Dto.addGame(game4);

		user8Dto.setUserName("samara");
		user8Dto.setEmail("samara@gmail.com");
		user8Dto.getAvalible().add(time2);
		user8Dto.getAvalible().add(time5);
		user8Dto.addGame(game3);

		user9Dto.setUserName("Policja");
		user9Dto.setEmail("chowamywszystkodopolaru@gmail.pl");
		user9Dto.getAvalible().add(time2);
		user9Dto.getAvalible().add(time4);
		user9Dto.addGame(game3);
		user9Dto.addGame(game2);
		user9Dto.addGame(game4);

		user10Dto.setUserName("Plastuś");
		user10Dto.setEmail("paparapa@sympatia.pl");
		user10Dto.getAvalible().add(time2);
		user10Dto.addGame(game2);
		user10Dto.addGame(game4);

		setUsersEntiti.add(user1);
		setUsersEntiti.add(user2);
		setUsersEntiti.add(user3);
		return userList;

	}

	public CommentEntiti comment1 = new CommentEntiti(Instant.parse("2018-08-25T10:15:30.00Z"), user1,
			"Subcio gra, misiaczki.");
	public CommentEntiti comment2 = new CommentEntiti(Instant.parse("2019-08-25T11:15:30.00Z"), user2, "Ale jajka");
	public CommentEntiti comment3 = new CommentEntiti(Instant.parse("2018-09-25T10:15:30.00Z"), user3,
			"Pieknie sie bawilismy");
	public CommentEntiti comment4 = new CommentEntiti(Instant.parse("2018-08-27T11:15:30.00Z"), user4,
			"super partia na kwadracie YO!");
	public CommentEntiti comment5 = new CommentEntiti(Instant.parse("2018-08-25T10:15:30.00Z"), user5,
			"Polska mistrzem Polski!!!!!");

	public AcceptationDto acceptationDto1 = new AcceptationDto(true, comment1);

	public AcceptationDto acceptationDto2 = new AcceptationDto(true, comment2);
	public AcceptationDto acceptationDto3 = new AcceptationDto(true, comment3);
	public AcceptationDto acceptationDto4 = new AcceptationDto(false, comment4);

}

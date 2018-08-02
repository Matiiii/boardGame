package com.capgemini.jstk.boardGame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.repository.dto.AcceptationTo;
import com.capgemini.jstk.boardGame.repository.dto.AvailableTimeTo;
import com.capgemini.jstk.boardGame.repository.dto.ChallengeTo;
import com.capgemini.jstk.boardGame.repository.dto.GameTo;
import com.capgemini.jstk.boardGame.repository.dto.UserTo;
import com.capgemini.jstk.boardGame.repository.entity.AvailableTimeEntity;
import com.capgemini.jstk.boardGame.repository.entity.CommentEntity;
import com.capgemini.jstk.boardGame.repository.entity.GameEntity;
import com.capgemini.jstk.boardGame.repository.entity.UserEntity;

@Component
public class MockDataInitializer {

	Set<UserEntity> setUsersEntiti = new HashSet<>();

	public ChallengeTo challengeDto1 = new ChallengeTo();
	public ChallengeTo challengeDto2 = new ChallengeTo();
	public ChallengeTo challengeDto3 = new ChallengeTo();

	public AvailableTimeEntity time1 = new AvailableTimeEntity(Instant.parse("2018-08-25T10:15:30.00Z"),
			Instant.parse("2018-08-26T10:15:30.00Z"));
	public AvailableTimeEntity time2 = new AvailableTimeEntity(Instant.parse("2018-08-26T10:15:30.00Z"),
			Instant.parse("2018-08-26T15:15:30.00Z"));
	public AvailableTimeEntity time3 = new AvailableTimeEntity(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-10T14:15:30.00Z"));
	public AvailableTimeEntity time4 = new AvailableTimeEntity(Instant.parse("2018-08-05T10:15:30.00Z"),
			Instant.parse("2018-08-05T10:15:30.00Z"));
	public AvailableTimeEntity time5 = new AvailableTimeEntity(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-12T10:15:30.00Z"));

	public AvailableTimeTo timeDto1 = new AvailableTimeTo(Instant.parse("2018-08-25T10:15:30.00Z"),
			Instant.parse("2018-08-26T10:15:30.00Z"));
	public AvailableTimeTo timeDto2 = new AvailableTimeTo(Instant.parse("2018-08-26T10:15:30.00Z"),
			Instant.parse("2018-08-26T15:15:30.00Z"));
	public AvailableTimeTo timeDto3 = new AvailableTimeTo(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-10T14:15:30.00Z"));
	public AvailableTimeTo timeDto4 = new AvailableTimeTo(Instant.parse("2018-08-05T10:15:30.00Z"),
			Instant.parse("2018-08-05T10:15:30.00Z"));
	public AvailableTimeTo timeDto5 = new AvailableTimeTo(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-12T10:15:30.00Z"));

	public GameEntity game1 = new GameEntity("Wyscig szczurow", 2, 6);
	public GameEntity game2 = new GameEntity("Szachy", 2, 2);
	public GameEntity game3 = new GameEntity("Magic", 2, 2);
	public GameEntity game4 = new GameEntity("Super Ściemniacz", 2, 8);

	public GameTo gameDto1 = new GameTo("Wyscig szczurow", 2, 6);
	public GameTo gameDto2 = new GameTo("Warcaby", 2, 2);
	public GameTo gameDto3 = new GameTo("dddddd", 2, 2);
	public GameTo gameDto4 = new GameTo("Solą do oka", 2, 8);

	public UserEntity user1 = new UserEntity();
	public UserEntity user2 = new UserEntity();
	public UserEntity user3 = new UserEntity();
	public UserEntity user4 = new UserEntity();
	public UserEntity user5 = new UserEntity();

	public UserTo user6Dto = new UserTo();
	public UserTo user7Dto = new UserTo();
	public UserTo user8Dto = new UserTo();
	public UserTo user9Dto = new UserTo();
	public UserTo user10Dto = new UserTo();

	@PostConstruct
	public List<UserEntity> createMokksUsersList() {

		challengeDto1.setId(1l);
		challengeDto1.setCommentList(new ArrayList<CommentEntity>());
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
		challengeDto2.setCommentList(new ArrayList<CommentEntity>());
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
		challengeDto3.setCommentList(new ArrayList<CommentEntity>());
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

		List<UserEntity> userList = new ArrayList<>();

		user1.setUserName("Mati");
		user1.setEmail("mati@mati.pl");
		user1.getAvailable().add(time1);
		user1.getAvailable().add(time2);
		user1.addGame(game1);
		user1.addGame(game2);
		user1.addGame(game3);
		user1.setCity("Poznan");

		userList.add(user1);

		user2.setUserName("Bartosh");
		user2.setEmail("mokrybartii@onet.pl");
		user2.getAvailable().add(time2);
		user2.getAvailable().add(time4);
		user2.addGame(game3);
		user2.addGame(game2);
		user2.addGame(game4);
		user2.setCity("Poznan");

		userList.add(user2);

		user3.setUserName("Stasiiiix");
		user3.setEmail("stasiapodpasia@gmail.com");
		user3.getAvailable().add(time2);
		user3.getAvailable().add(time5);
		user3.addGame(game3);
		user3.setCity("Poznan");

		userList.add(user3);

		user4.setUserName("PaTrYcJa");
		user4.setEmail("patrycja.kulfon@gmail.pl");
		user4.getAvailable().add(time2);
		user4.getAvailable().add(time4);
		user4.addGame(game3);
		user4.addGame(game2);
		user4.addGame(game4);
		user4.setCity("Poznan");

		userList.add(user4);

		user5.setUserName("Bohdan");
		user5.setEmail("prezny@sympatia.pl");
		user5.getAvailable().add(time2);
		user5.addGame(game2);
		user5.addGame(game4);
		user5.setCity("Poznan");

		user6Dto.setUserName("Mariusz");
		user6Dto.setEmail("mariusz@mati.pl");
		user6Dto.getAvailable().add(time1);
		user6Dto.getAvailable().add(time2);
		user6Dto.addGame(game1);
		user6Dto.addGame(game2);
		user6Dto.addGame(game3);
		user6Dto.setCity("Poznań");

		user7Dto.setUserName("Barabara");
		user7Dto.setEmail("booblebody@onet.pl");
		user7Dto.getAvailable().add(time2);
		user7Dto.getAvailable().add(time4);
		user7Dto.addGame(game3);
		user7Dto.addGame(game2);
		user7Dto.addGame(game4);
		user7Dto.setCity("Poznań");

		user8Dto.setUserName("samara");
		user8Dto.setEmail("samara@gmail.com");
		user8Dto.getAvailable().add(time2);
		user8Dto.getAvailable().add(time5);
		user8Dto.addGame(game3);
		user8Dto.setCity("Poznań");

		user9Dto.setUserName("Policja");
		user9Dto.setEmail("chowamywszystkodopolaru@gmail.pl");
		user9Dto.getAvailable().add(time2);
		user9Dto.getAvailable().add(time4);
		user9Dto.addGame(game3);
		user9Dto.addGame(game2);
		user9Dto.addGame(game4);
		user9Dto.setCity("Poznań");

		user10Dto.setUserName("Plastuś");
		user10Dto.setEmail("paparapa@sympatia.pl");
		user10Dto.getAvailable().add(time2);
		user10Dto.addGame(game2);
		user10Dto.addGame(game4);
		user10Dto.setCity("Poznań");

		setUsersEntiti.add(user1);
		setUsersEntiti.add(user2);
		setUsersEntiti.add(user3);
		return userList;

	}

	public CommentEntity comment1 = new CommentEntity(Instant.parse("2018-08-25T10:15:30.00Z"), user1,
			"Subcio gra, misiaczki.");
	public CommentEntity comment2 = new CommentEntity(Instant.parse("2019-08-25T11:15:30.00Z"), user2, "Ale jajka");
	public CommentEntity comment3 = new CommentEntity(Instant.parse("2018-09-25T10:15:30.00Z"), user3,
			"Pieknie sie bawilismy");
	public CommentEntity comment4 = new CommentEntity(Instant.parse("2018-08-27T11:15:30.00Z"), user4,
			"super partia na kwadracie YO!");
	public CommentEntity comment5 = new CommentEntity(Instant.parse("2018-08-25T10:15:30.00Z"), user5,
			"Polska mistrzem Polski!!!!!");

	public AcceptationTo acceptationDto1 = new AcceptationTo(true, comment1);

	public AcceptationTo acceptationDto2 = new AcceptationTo(true, comment2);
	public AcceptationTo acceptationDto3 = new AcceptationTo(true, comment3);
	public AcceptationTo acceptationDto4 = new AcceptationTo(false, comment4);

}

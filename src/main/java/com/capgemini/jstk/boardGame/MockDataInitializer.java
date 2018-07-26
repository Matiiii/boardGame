package com.capgemini.jstk.boardGame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardGame.dto.UserDto;
import com.capgemini.jstk.boardGame.model.AvalibleTimeEntiti;
import com.capgemini.jstk.boardGame.model.CommentEntiti;
import com.capgemini.jstk.boardGame.model.GameEntiti;
import com.capgemini.jstk.boardGame.model.UserEntiti;

@Component
public class MockDataInitializer {

	AvalibleTimeEntiti time1 = new AvalibleTimeEntiti(Instant.parse("2018-08-25T10:15:30.00Z"),
			Instant.parse("2018-08-26T10:15:30.00Z"));
	AvalibleTimeEntiti time2 = new AvalibleTimeEntiti(Instant.parse("2018-08-26T10:15:30.00Z"),
			Instant.parse("2018-08-26T15:15:30.00Z"));
	AvalibleTimeEntiti time3 = new AvalibleTimeEntiti(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-10T14:15:30.00Z"));
	AvalibleTimeEntiti time4 = new AvalibleTimeEntiti(Instant.parse("2018-08-05T10:15:30.00Z"),
			Instant.parse("2018-08-05T10:15:30.00Z"));
	AvalibleTimeEntiti time5 = new AvalibleTimeEntiti(Instant.parse("2018-08-10T10:15:30.00Z"),
			Instant.parse("2018-08-12T10:15:30.00Z"));

	public GameEntiti game1 = new GameEntiti("Wyscig szczurow", 2, 6);
	public GameEntiti game2 = new GameEntiti("Szachy", 2, 2);
	public GameEntiti game3 = new GameEntiti("Magic", 2, 2);
	public GameEntiti game4 = new GameEntiti("Super Ściemniacz", 2, 8);

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

		userList.add(user5);

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

		return userList;

	}

	CommentEntiti comment1 = new CommentEntiti(Instant.parse("2018-08-25T10:15:30.00Z"), user1,
			"Subcio gra, misiaczki.");
	CommentEntiti comment2 = new CommentEntiti(Instant.parse("2019-08-25T11:15:30.00Z"), user2, "Ale jajka");
	CommentEntiti comment3 = new CommentEntiti(Instant.parse("2018-09-25T10:15:30.00Z"), user3,
			"Pieknie sie bawilismy");
	CommentEntiti comment4 = new CommentEntiti(Instant.parse("2018-08-27T11:15:30.00Z"), user4,
			"super partia na kwadracie YO!");
	CommentEntiti comment5 = new CommentEntiti(Instant.parse("2018-08-25T10:15:30.00Z"), user5,
			"Polska mistrzem Polski!!!!!");

}

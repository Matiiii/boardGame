package com.capgemini.jstk.boardGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
public class BoardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardGameApplication.class, args);

	}
}

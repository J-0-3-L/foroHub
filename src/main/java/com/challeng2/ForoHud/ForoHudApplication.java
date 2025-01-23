package com.challeng2.ForoHud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ForoHudApplication {
	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
	
		SpringApplication.run(ForoHudApplication.class, args);
	}

}

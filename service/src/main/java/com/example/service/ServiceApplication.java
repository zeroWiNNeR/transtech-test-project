package com.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {

		String sql = "CREATE DATABASE transtech_db";
		try (Connection db = DriverManager.getConnection("jdbc:postgresql://db:5432/", "postgres", "postgres")) {
			Statement stmt = db.createStatement();
			stmt.execute(sql);
		} catch (Exception e) {
			e.getLocalizedMessage();
			System.out.println(e.toString());
		}

		SpringApplication.run(ServiceApplication.class, args);
	}

}
